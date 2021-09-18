package com.winner.mes.ems.annotation;

import com.winner.mes.ems.aop.ParamsType;

import java.lang.annotation.*;

/**
 * @author yzz
 * @date 2021/8/9
 * @description
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CodeConvert {

    Class<? extends ParamsType> data();

    CodeMapping[] mapping() default {@CodeMapping()};

}
