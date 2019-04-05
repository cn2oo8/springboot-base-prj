package com.shareyi.basespringboot.common.exception;

import com.shareyi.basespringboot.common.enums.ResultCodeEnum;

/**
 * 异常构建器，用于抛出异常
 *
 * @author david
 * @date 2018/8/21
 */
public class ExceptionMaker {

    /**
     * 构建异常
     *
     * @param resultCodeEnum
     * @return
     */
    public static AutoCodeException buildException(ResultCodeEnum resultCodeEnum) {
        return new AutoCodeException(resultCodeEnum);
    }

    /**
     * 构建异常
     *
     * @param message
     * @param resultCodeEnum
     * @return
     */
    public static AutoCodeException buildException(String message, ResultCodeEnum resultCodeEnum) {
        return new AutoCodeException(message, resultCodeEnum.codeString());
    }


}
