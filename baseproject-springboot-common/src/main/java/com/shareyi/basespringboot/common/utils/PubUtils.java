package com.shareyi.basespringboot.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 通用工具类
 */
public class PubUtils {

    /**
     * 获取随机的Long
     *
     * @return 随机Long
     */
    public static Long generateRandomLong() {
        Random random = new Random();
        return random.nextLong();
    }

    /**
     * 生成UUID
     *
     * @return 无-的，且大写32位的UUID
     */
    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "").toUpperCase();
    }

    /**
     * 获取当前年月日
     *
     * @return yyyy-MM-dd
     */
    public static String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    /**
     * 获取年月日和时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }


    /**
     * 获取当前的时间戳
     *
     * @return 时间戳
     */
    public static long getTime() {
        return System.currentTimeMillis();
    }

    /**
     * List转换为String,用逗号间隔
     * 如： col1,col2,col3
     *
     * @param list
     * @return
     */
    public static String listToStr(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * String转换为List,用逗号间隔
     * 将 col1,col2,col3 以逗号分隔为list的元素
     *
     * @param str
     * @return
     */
    public static List<String> stringToList(String str) {
        List<String> list = new ArrayList<String>();
        if (str != null && str.trim().length() != 0) {
            String[] strs = str.split(",");
            for (String string : strs) {
                list.add(string);
            }
        }
        return list;
    }

    /**
     * 包名转路径
     * 如：com.shareyi.xxx 转换为： com/shareyi/xxx
     *
     * @param str
     * @return
     */
    public static String packageToPath(String str) {
        return str.replace('.', '/');
    }


    /**
     * 路径转换为包名
     * 如： com/shareyi/xxx 转换为：com.shareyi.xxx
     *
     * @param str
     * @return
     */
    public static String pathToPackage(String str) {
        str = str.replace('/', '.');
        return str.replace('\\', '.');
    }


    /**
     * 如果字符串不为空，将字符串拼接到分隔符后面
     * 否则返回空串
     * 如：("path","/") -->  /path
     *
     * @param str
     * @return
     */
    public static String addStrBeforeSeparator(String str, String sep) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }

        return str + sep;
    }


    /**
     * 如果字符串不为空，将字符串拼接到分隔符后面
     * 否则返回空串
     * 如：("path","/") -->  /path
     *
     * @param str
     * @return
     */
    public static String addStrAfterSeparator(String str, String sep) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }

        return sep + str;
    }


}
