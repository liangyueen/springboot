package book.store.utils;


import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * User: chengzh
 * <p>
 * Date: 18-3-15 Time: 上午11:26
 * <p>
 * Description:
 */
public class ValidatorUtils {

    private ValidatorUtils() {
    }

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> String validate(T t) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        Set<String> messages = constraintViolations.stream().map(f -> f.getMessage()).collect(Collectors.toSet());
        return StringUtils.join(messages.toArray(), ",");
    }

    public static <T> String validate(T t, org.springframework.validation.Validator springValidator)

    {
        BindException errors = new BindException(t, t.getClass().getName());
        ValidationUtils.invokeValidator(springValidator, t, errors);

        Set<String> messages = errors.getFieldErrors().stream().map(f -> f.getCode()).collect(Collectors.toSet());
        return StringUtils.join(messages.toArray(), ",");

    }

    public static <T> String validateAll(T t, org.springframework.validation.Validator springValidator)

    {
        String prefix = validate(t);
        String suffix = validate(t, springValidator);
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(prefix)) sb.append(prefix + ", ");
        if (StringUtils.isNotBlank(suffix)) sb.append(suffix);
        if (StringUtils.endsWith(sb.toString(), ", ")) sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }


}