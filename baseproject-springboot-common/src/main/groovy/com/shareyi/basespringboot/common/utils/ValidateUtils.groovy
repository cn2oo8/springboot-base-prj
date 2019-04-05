package com.shareyi.basespringboot.common.utils

import com.shareyi.basespringboot.common.valid.Validate

/**
 * 验证工具类
 * @author david
 * @date 2018/9/1
 */
class ValidateUtils {

    static void notNullField(Object obj, String fieldName) {
        Validate.notNull(obj[fieldName], fieldName + "不能为空");
    }

    static void notEmptyField(Object obj, String fieldName) {
        Validate.notEmpty(obj[fieldName], fieldName + "不能为空");
    }
}
