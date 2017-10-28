package cn.dolphin.action.annotation;

import java.lang.annotation.*;

/**
 * Created by LiLinZhi
 * Date: 17/8/16
 * Time: 上午12:13
 * Version: 1.0
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTag {

    String name() default "车";

    int size() default 10;
}
