package com.ly.xiyifu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @文件名称： JsonMapper
 * @包路径： book.store.utils
 * @版权所有：
 * @类描述：
 * @创建人： czh
 * @创建时间： 2018/07/24 - 21:16
 * @修改记录：
 */
public class JsonMapper {

    private JsonMapper() {
    }

    public final static ObjectMapper jsonMapper = new ObjectMapper();
}
