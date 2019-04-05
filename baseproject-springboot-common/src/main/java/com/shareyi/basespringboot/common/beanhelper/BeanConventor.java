package com.shareyi.basespringboot.common.beanhelper;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * bean 转换器
 *
 * @author david
 * @date 2017/10/18
 */
public class BeanConventor {


    static Logger LOGGER = LoggerFactory.getLogger(BeanConventor.class);

    /**
     * 通过bean,构建查询条件Map
     *
     * @param bean
     * @return
     */
    public static Map<String, Object> buildQueryMapByBean(Object bean) {
        if (bean == null) {
            return null;
        }

        Map<String, Object> queryMap = new HashMap();
        try {
            //bean utils有缓存
            BeanDescribeInfo beanDescribeInfo = BeanHelper.describeBean(bean);
            for (Field field : beanDescribeInfo.getBeanFields()) {
                String filedName = field.getName();
                PropertyDescriptor descriptor = beanDescribeInfo.getPropertyDescriptor(filedName);
                if (descriptor == null) {
                    continue;
                }
                Object value = descriptor.getReadMethod().invoke(bean);
                if (value == null) {
                    continue;
                }

                BeanQueryFiled queryFiled = field.getAnnotation(BeanQueryFiled.class);
                String key = filedName;
                if (queryFiled != null) {
                    //if ignore this filed ,skip this
                    if (queryFiled.ignore()) {
                        continue;
                    }

                    if (StringUtils.isNotEmpty(queryFiled.queryKey())) {
                        key = queryFiled.queryKey();
                    } else if (StringUtils.isNotEmpty(queryFiled.prepend())) {
                        key = queryFiled.queryKey() + key;
                    }
                }

                queryMap.put(key, value);

            }

        } catch (Exception e) {
            LOGGER.error("转换BEAN到 QueryBuilder异常，bean=" + JSON.toJSONString(bean), e);
        }
        return queryMap;
    }


    /**
     * 将MAP查询扁平化
     *
     * @param queryMap
     * @param key
     * @param map
     */
    public static void flatMapQuery(Map<String, Object> queryMap, String key, Map map) {
        Set<Map.Entry> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet) {
            String subKey = String.valueOf(entry.getKey());
            Object value = entry.getValue();
            if (value == null) {
                continue;
            }
            queryMap.put(contactField(key, subKey), value);
        }

    }


    /**
     * 拼接字段key
     *
     * @param parent
     * @param key
     * @return
     */
    public static String contactField(String parent, String key) {
        if (parent == null || parent.isEmpty()) {
            return key;
        }
        if (parent.endsWith(".")) {
            return parent + key;
        }
        return parent + "." + key;
    }
}
