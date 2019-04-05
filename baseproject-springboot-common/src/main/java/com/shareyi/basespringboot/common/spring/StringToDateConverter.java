package com.shareyi.basespringboot.common.spring;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串转日期工具类
 *
 * @author david
 * @date 2018-08-25
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     * 日期转换器
     */
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期转换器2
     */
    private static final String shortDateFormat = "yyyy-MM-dd";
    /**
     * 日期转换器3
     */
    private static final String dateFormat2 = "yyyy/MM/dd HH:mm:ss";
    /**
     * 日期转换器4
     */
    private static final String shortDateFormat2 = "yyyy/MM/dd";

    @Override
    public Date convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        source = source.trim();
        try {
            SimpleDateFormat formatter;
            if (source.contains("-")) {
                if (source.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                    formatter = new SimpleDateFormat(shortDateFormat);
                }
                Date dtDate = formatter.parse(source);
                return dtDate;
            } else if (source.contains("/")) {
                if (source.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat2);
                } else {
                    formatter = new SimpleDateFormat(shortDateFormat2);
                }
                Date dtDate = formatter.parse(source);
                return dtDate;
            } else if (StringUtils.isNumeric(source)) {
                return new Date(Long.valueOf(source));
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", source));
        }
        throw new RuntimeException(String.format("parser %s to Date fail", source));

    }
}