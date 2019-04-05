/**
 * Copyright(C) 2004-2017 JD.COM All Right Reserved
 */
package com.shareyi.basespringboot.common.valid;

import com.shareyi.basespringboot.common.enums.ResultCodeEnum;
import com.shareyi.basespringboot.common.exception.ExceptionMaker;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * <p> </p>
 *
 * @author david
 * @created 2017-09-26 12:04
 */
public class Validate {

    /**
     * 范围验证
     *
     * @param val
     * @param min
     * @param max
     * @param message
     */
    public static void range(int val, Integer min, Integer max, String message) {
        if (min == null && max == null) {
            return;
        }
        if (min != null && val < min) {
            throw ExceptionMaker.buildException(message, ResultCodeEnum.PARAM_ERROR);
        }
        if (max != null && val > max) {
            throw ExceptionMaker.buildException(message, ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * 是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Collection) {
            if (((Collection) obj).size() == 0) {
                return true;
            }
        } else if (obj instanceof Map) {
            if (((Map) obj).size() == 0) {
                return true;
            }
        } else if (obj.getClass().isArray()) {
            if (((Object[]) obj).length == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 不能为空
     *
     * @param obj
     * @param message
     */
    public static void notNull(Object obj, String message) {
        if (isNull(obj)) {
            throw ExceptionMaker.buildException(message, ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * 是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String && StringUtils.isBlank((String) obj)) {
            return true;
        }
        return false;
    }

    /**
     * 不为空
     *
     * @param obj
     * @param message
     */
    public static void notEmpty(Object obj, String message) {
        if (isEmpty(obj)) {
            throw ExceptionMaker.buildException(message, ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * 是否为true
     *
     * @param check
     * @param message
     */
    public static void assertTrue(boolean check, String message) {
        if (!check) {
            throw ExceptionMaker.buildException(message, ResultCodeEnum.PARAM_ERROR);
        }
    }

}
