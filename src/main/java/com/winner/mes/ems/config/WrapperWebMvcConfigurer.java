package com.winner.mes.ems.config;

import com.winner.mes.ems.controller.handler.ResultWrapperReturnValueHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author yzz
 * @date 2021/7/12
 * @description
 */
@Configuration
public class WrapperWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        handlers.add(new ResultWrapperReturnValueHandler());
    }
}

