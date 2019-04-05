package com.shareyi.basespringboot.sdk.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础扩展信息dto
 *
 * @author david
 * @date 2018/1/10
 */
public class ExtAttrDto implements Serializable {

    /**
     * 扩展信息map
     */
    private Map<String, Object> extInfoMap;

    /**
     * 获取扩展属性map
     *
     * @return
     */
    public Map<String, Object> getExtInfoMap() {
        return extInfoMap;
    }

    /**
     * 设置扩展属性Map
     *
     * @param extInfoMap
     */
    public void setExtInfoMap(Map<String, Object> extInfoMap) {
        this.extInfoMap = extInfoMap;
    }

    /**
     * 设置扩展属性信息
     *
     * @param key
     * @param value
     * @return
     */
    public ExtAttrDto putExtInfo(String key, Object value) {
        if (extInfoMap == null) {
            extInfoMap = new HashMap();
        }
        extInfoMap.put(key, value);
        return this;
    }

    /**
     * 获取object类型的扩展信息
     *
     * @param key
     * @return
     */
    public Object getExtObject(String key) {
        return getExtObject(key, null);
    }

    /**
     * 获取object类型的扩展信息
     *
     * @param key
     * @return
     */
    public Object getExtObject(String key, Object defVal) {
        if (extInfoMap == null) {
            return null;
        }
        Object value = extInfoMap.get(key);
        return value == null ? defVal : value;
    }

    /**
     * 获取字符串类型的扩展信息
     *
     * @param key
     * @return
     */
    public String getExtStr(String key) {
        return getExtStr(key, null);
    }

    /**
     * 获取字符串类型的扩展信息
     *
     * @param key
     * @return
     */
    public String getExtStr(String key, String defVal) {
        Object obj = getExtObject(key, defVal);
        return obj == null ? defVal : obj.toString();
    }
}
