package com.shareyi.basespringboot.common.utils;

/**
 * 系统工具类
 *
 * @author david
 * @date 2018/11/2
 */
public class SystemUtils {

    /**
     * 获取系统名称
     *
     * @return
     */
    public static String getOsName() {
        String osName = System.getProperties().getProperty("os.name");
        return osName;
    }

    /**
     * 是否windows
     *
     * @return
     */
    public static boolean isWindows() {
        String osName = getOsName();
        if (osName != null) {
            return osName.toUpperCase().indexOf("WINDOWS") != -1;
        }
        return false;
    }
}
