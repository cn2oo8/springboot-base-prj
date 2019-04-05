package com.shareyi.basespringboot.common.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 系统常量获取，单列模式
 *
 * @author david
 * @date 2018/11/1
 */
public class Profiles {

    /**
     * 单例
     */
    final static Profiles INSTANCE = new Profiles();


    /**
     * 缓存map
     */
    private Map<String, Object> cacheMap = new ConcurrentHashMap<>();

    /**
     * 获取单例
     *
     * @return
     */
    public static Profiles getInstance() {
        return INSTANCE;
    }

    /**
     * 放置缓存信息
     *
     * @param key
     * @param data
     * @return
     */
    public Profiles putCache(String key, String data) {
        cacheMap.put(key, data);
        return this;
    }

    /**
     * 获取缓存信息
     *
     * @param key
     * @return
     */
    public Object getCache(String key) {
        return cacheMap.get(key);
    }

}
