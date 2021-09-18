package com.winner.mes.ems.aop;

import cn.hutool.core.bean.BeanUtil;
import com.purcotton.obj.response.PageResponse;
import com.winner.mes.ems.annotation.CodeConvert;
import com.winner.mes.ems.annotation.CodeMapping;
import com.winner.mes.ems.pojo.DictionaryVo;
import com.winner.mes.ems.pojo.MappingVo;
import com.winner.mes.ems.utils.DataConvertUtil;
import com.winner.mes.ems.utils.WinSpringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.winner.mes.ems.utils.DataConvertUtil.dataConvert;
import static com.winner.mes.ems.utils.DataConvertUtil.parseAnnotation;

@Component
@Aspect
public class BaseCodeAspect {

    @Pointcut(value = "@annotation(com.winner.mes.ems.annotation.CodeConvert)")
    private void pointcut() {

    }

    /**
     * 执行完被注解的方法后需执行的方法
     *
     * @param joinPoint
     * @return
     */
    @AfterReturning(value = "pointcut() && @annotation(com.winner.mes.ems.annotation.CodeConvert)", returning = "result")
    public Object afterRunning(JoinPoint joinPoint, Object result) {
        if (BeanUtil.isEmpty(result)) {
            return result;
        }
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        CodeConvert annotation = method.getAnnotation(CodeConvert.class);
        Object ob = WinSpringUtil.getBean(annotation.data());
        if (ob != null && ob instanceof ParamsType) {
            List<MappingVo> data = ((ParamsType) ob).dataByType(parseAnnotation(annotation));
            dataConvert(data, result);
        }
        return result;
    }
}