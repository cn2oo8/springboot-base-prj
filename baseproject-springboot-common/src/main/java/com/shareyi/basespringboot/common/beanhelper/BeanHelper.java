package com.shareyi.basespringboot.common.beanhelper;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * bean相关属性获取工具类
 *
 * @author david
 * @date 2017/9/30
 */
public class BeanHelper {

    /**
     * 单例
     */
    private static BeanHelper INSTANCE = new BeanHelper();

    /**
     * bean描述缓存map
     */
    private WeakHashMap<Class, BeanDescribeInfo> describeBeanCache;
    /**
     * 并发锁
     */
    private ReadWriteLock readWriteLock;

    /**
     * bean辅助类
     */
    public BeanHelper() {
        this.describeBeanCache = new WeakHashMap();
        readWriteLock = new ReentrantReadWriteLock();
    }

    /**
     * 描述信息
     *
     * @param bean
     * @return
     */
    public static BeanDescribeInfo describeBean(Object bean) {
        if (bean == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        return describeClass(bean.getClass());
    }


    /**
     * 通过class对 属性进行解析&缓存
     *
     * @param beanClass
     * @return
     */
    public static BeanDescribeInfo describeClass(Class<?> beanClass) {
        if (beanClass == null) {
            throw new IllegalArgumentException("No beanClass specified");
        }
        BeanDescribeInfo describeInfo = INSTANCE.get(beanClass);
        if (describeInfo != null) {
            return describeInfo;
        }
        describeInfo = new BeanDescribeInfo(beanClass);
        describeClass(beanClass, describeInfo);
        INSTANCE.put(beanClass, describeInfo);
        return describeInfo;
    }


    /**
     * 通过class对bean进行描述性解析
     *
     * @param beanClass
     * @param describeInfo
     * @return
     */
    private static BeanDescribeInfo describeClass(Class beanClass, BeanDescribeInfo describeInfo) {
        Field[] childClassField = beanClass.getDeclaredFields();
        for (Field field : childClassField) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isTransient(modifiers)) {
                continue;
            }
            if (describeInfo.containsField(field.getName())) {
                continue;
            }
            PropertyDescriptor descriptor = getDescriptorByField(beanClass, field);
            if (descriptor == null) {
                continue;
            }
            describeInfo.addFieldAndDescriptor(field, descriptor);
        }

        Class parentClass = beanClass.getSuperclass();
        if (parentClass != null && parentClass != Object.class) {
            describeClass(parentClass, describeInfo);
        }
        return describeInfo;
    }


    /**
     * 通过field获取属性表述符
     *
     * @param beanClass
     * @param field
     * @return
     */
    private static PropertyDescriptor getDescriptorByField(Class<?> beanClass, Field field) {
        String name = field.getName();
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new PropertyDescriptor(name, beanClass);
        } catch (IntrospectionException e) {
            //  e.printStackTrace();
        }
        return propertyDescriptor;
    }


    /**
     * 从缓存中，获取class的 bean描述符
     *
     * @param beanClass
     * @return
     */
    private BeanDescribeInfo get(Class<?> beanClass) {
        if (readWriteLock.readLock().tryLock()) {
            try {
                return describeBeanCache.get(beanClass);
            } finally {
                readWriteLock.readLock().unlock();
            }
        }
        return null;
    }


    /**
     * 存储到缓存map中， weakHashMap
     *
     * @param beanClass
     * @param describeInfo
     */
    private void put(Class<?> beanClass, BeanDescribeInfo describeInfo) {
        if (readWriteLock.writeLock().tryLock()) {
            try {
                describeBeanCache.put(beanClass, describeInfo);
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }
    }
}
