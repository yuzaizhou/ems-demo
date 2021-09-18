package com.winner.mes.ems.annotation;

import java.lang.annotation.*;

/**
 * @author yzz
 * @date 2021/8/12
 * @description
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CodeMapping {
    String source() default "status";

    String target() default "statusDesc";

    String mapping() default "" ;
}
