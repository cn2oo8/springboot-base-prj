package com.shareyi.basespringboot.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志辅助工具类
 *
 * @author david
 * @date 2017/12/12
 */
public class LogHelper {

    /**
     * 默认日志
     */
    public static final Logger DEFAULT = LoggerFactory.getLogger("defaultLog");
    /**
     * 异常日志
     */
    public static final Logger EXCEPTION = LoggerFactory.getLogger("exceptionLog");
    /**
     * 前台日志
     */
    public static final Logger FRONT_CONSOLE = LoggerFactory.getLogger("frontConsole");

}
