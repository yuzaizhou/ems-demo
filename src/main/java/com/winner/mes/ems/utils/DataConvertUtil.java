package com.winner.mes.ems.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winner.mes.ems.annotation.CodeConvert;
import com.winner.mes.ems.annotation.CodeMapping;
import com.winner.mes.ems.pojo.MappingVo;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yzz
 * @date 2021/8/4
 * @description
 */
public class DataConvertUtil {
    public static void dataConvert(List<MappingVo> source, Object target) {
        if (source.isEmpty()) {
            throw new RuntimeException("参数错误！");
        }
        if (target instanceof IPage) {
            ((IPage<?>) target).getRecords().forEach(var1 -> {
                setMappingValue(var1, source);
            });
        } else if (target instanceof List) {
            ((List<?>) target).forEach(var1 -> {
                setMappingValue(var1, source);
            });
        } else if (target instanceof Map) {
            setMappingValue((Map<String, Object>) target, source);
        } else {
            setMappingValue(target, source);
        }
    }

    private static void setMappingValue(Object var2, List<MappingVo> mappingList) {
        Class clazz = var2.getClass();
        mappingList.forEach(var3 -> {
            try {
                Field sourceField = clazz.getDeclaredField(var3.getSource());
                Field targetField = clazz.getDeclaredField(var3.getTarget());
                if (!sourceField.isAccessible()) {
                    sourceField.setAccessible(true);
                }
                if (!targetField.isAccessible()) {
                    targetField.setAccessible(true);
                }
                if (var3.getCode().equals(sourceField.get(var2).toString())) {
                    if ("java.lang.String".equals(targetField.getType().getName())) {
                        targetField.set(var2, var3.getName());
                    } else {
                        targetField.set(var2, beanTrans(var3, targetField.getType()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("参数错误！");
            }
        });
    }

    private static void setMappingValue(Map<String, Object> map, List<MappingVo> mappingList) {
        mappingList.forEach(var3 -> {
            try {
                Object var4 = map.get(var3.getSource());
                Object var5 = map.get(var3.getTarget());
                if (var3.getCode().equals(var4.toString())) {
                    map.put(var3.getTarget(), beanTrans(var3, var5.getClass()));
                }
            } catch (Exception e) {
                throw new RuntimeException("参数错误！");
            }
        });
    }

    public static <T> T beanTrans(Object source, Class target) throws Exception {
        Class clazz = source.getClass();
        Field[] sourceFields = clazz.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();
        Object newEntity = target.newInstance();
        for (Field targetField : targetFields) {
            targetField.setAccessible(true);
            for (Field sourceField : sourceFields) {
                sourceField.setAccessible(true);
                if (sourceField.getName().equals(targetField.getName())) {
                    targetField.set(newEntity, sourceField.get(source));
                    break;
                }
            }
        }
        return (T) newEntity;
    }

    public static List<MappingVo> parseAnnotation(CodeConvert annotation) {
        CodeMapping[] mapping = annotation.mapping();
        List<MappingVo> mappingVoList = Arrays.stream(mapping).map((t) -> {
            MappingVo mappingVo = new MappingVo();
            mappingVo.setSource(t.source());
            mappingVo.setTarget(t.target());
            if (!StringUtils.isBlank(t.mapping())) {
                mappingVo.setDataTypeCode(t.mapping());
            }
            return mappingVo;
        }).collect(Collectors.toList());
        return mappingVoList;
    }

    private static Field[] getAllFields(Class<?> clazz) {
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        return fieldList.toArray(fields);
    }

}