package com.wang.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author wang
 * @version 1.0.0
 * @description 对象转换工具
 * @date 2022/12/24 07:09
 */
@Slf4j
public class ConvertUtil {

    /**
     * 单个对象转换
     * @param source 来源对象
     * @param target 目标对象类
     * @param <T>    目标对象类型
     * @return 目标对象
     */
    public static <T> T sourceToTarget(Object source, Class<T> target) {
        return sourceToTarget(source, target, (Class<?>) null);
    }

    /**
     * 单个对象转换,只把源对象的 targetSuper的属性同步到目标对象
     * @param source      来源对象
     * @param target      目标对象类
     * @param <T>         目标对象类型
     * @param targetSuper 目标对象的父类
     * @return 目标对象
     */
    public static <T> T sourceToTarget(Object source, Class<T> target, Class<?> targetSuper) {
        if (source == null) {
            return null;
        }
        T targetObject = null;
        try {
            targetObject = target.newInstance();
            BeanUtils.copyProperties(source, targetObject, targetSuper);
        } catch (Exception e) {
            log.error("convert error {} {} {}", source, target, targetSuper, e);
        }
        return targetObject;
    }

    /**
     * 数组转换
     *
     * @param sourceList 来源对象数组
     * @param target     目标对象类
     * @param <T>        目标对象类型
     * @return 目标对象数组
     */
    public static <T> List<T> sourceToTarget(Collection<?> sourceList, Class<T> target) {
        if (sourceList == null) {
            return null;
        }
        List<T> targetList = new ArrayList<>(sourceList.size());
        try {
            for (Object source : sourceList) {
                T targetObject = target.newInstance();
                BeanUtils.copyProperties(source, targetObject);
                targetList.add(targetObject);
            }
        } catch (Exception e) {
            log.error("convert error {} {} {}", sourceList, target, e);
        }
        return targetList;
    }
}
