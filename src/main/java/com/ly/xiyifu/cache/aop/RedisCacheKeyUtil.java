package com.ly.xiyifu.cache.aop;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class RedisCacheKeyUtil {

    private static Logger log = LoggerFactory.getLogger(RedisCacheKeyUtil.class);

    public static String parseKey(String key, Object[] args) {
        if (StringUtils.isEmpty(key) || args == null) {
            return null;
        }

        SimpleContext simple = new SimpleContext();
        simple.args = args;
        StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);
        ExpressionParser parser = new SpelExpressionParser();
        try {
            return parser.parseExpression(key).getValue(simpleContext).toString();
        } catch (Exception e) {
            log.error("RedisCacheKeyUtil error", e);
            return null;
        }
    }

}

class SimpleContext {

    public Object[] args;

}
