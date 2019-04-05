package com.shareyi.basespringboot.common.utils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 不用guava的list，非常安全
 *
 * @author david
 * @date 2017/6/1
 */
public class MyLists {

    /**
     * 转换列表
     *
     * @param fromList
     * @param function
     * @param <F>
     * @param <T>
     * @return
     */
    public static <F, T> List<T> transform(List<F> fromList, Function<? super F, ? extends T> function) {
        return transformInner(fromList, function, false);
    }


    /**
     * 转换列表不包含null值
     *
     * @param fromList
     * @param function
     * @param <F>
     * @param <T>
     * @return
     */
    public static <F, T> List<T> transformNotNull(List<F> fromList, Function<? super F, ? extends T> function) {
        return transformInner(fromList, function, true);
    }

    /**
     * 内部转换 List
     *
     * @param fromList   来源list
     * @param function   转换工具
     * @param filterNull 是否过滤null值
     * @param <F>        入参对象
     * @param <T>        出参对象
     * @return
     */
    private static <F, T> List<T> transformInner(List<F> fromList,
                                                 Function<? super F, ? extends T> function,
                                                 boolean filterNull) {
        if (CollectionUtils.isEmpty(fromList)) {
            return new ArrayList<T>(0);
        }

        List<T> resultList = new ArrayList<T>(fromList.size());
        for (F f : fromList) {
            T data = function.apply(f);
            if (filterNull && data == null) {
                continue;
            }
            resultList.add(data);
        }
        return resultList;
    }


    /**
     * 将List对象，转换为Set对象
     *
     * @param fromList
     * @param function
     * @param <F>
     * @param <T>
     * @return
     */
    public static <F, T> Set<T> transformSet(List<F> fromList, Function<? super F, ? extends T> function) {
        return transformSetInner(fromList, function, false);
    }


    /**
     * 将List对象，转换为Set对象，并过滤为空值
     *
     * @param fromList
     * @param function
     * @param <F>
     * @param <T>
     * @return
     */
    public static <F, T> Set<T> transformSetNotNull(List<F> fromList,
                                                    Function<? super F, ? extends T> function) {
        return transformSetInner(fromList, function, true);
    }


    /**
     * 内部执行
     *
     * @param fromList
     * @param function
     * @param filterNull
     * @param <F>
     * @param <T>
     * @return
     */
    private static <F, T> Set<T> transformSetInner(List<F> fromList,
                                                   Function<? super F, ? extends T> function,
                                                   boolean filterNull) {
        if (CollectionUtils.isEmpty(fromList)) {
            return new HashSet<T>(0);
        }

        HashSet<T> resultList = new HashSet<T>(fromList.size());
        for (F f : fromList) {
            T data = function.apply(f);
            if (filterNull && data == null) {
                continue;
            }
            resultList.add(data);
        }
        return resultList;
    }

    /**
     * 执行数据分拆，并返回安全的arrayList对象
     *
     * @param fromList
     * @param size
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> partition(List<T> fromList, int size) {
        List<List<T>> partList = Lists.partition(fromList, size);
        List<List<T>> resultList = new ArrayList<List<T>>(partList.size());
        for (List<T> part : partList) {
            resultList.add(new ArrayList<T>(part));
        }
        return resultList;
    }

    /**
     * 执行数据分拆，并返回安全的HashSet对象
     *
     * @param fromList
     * @param size
     * @param <T>
     * @return
     */
    public static <T> List<Set<T>> partitionSet(List<T> fromList, int size) {
        List<List<T>> partList = Lists.partition(fromList, size);
        List<Set<T>> resultList = new ArrayList<Set<T>>(partList.size());
        for (List<T> part : partList) {
            resultList.add(new HashSet<T>(part));
        }
        return resultList;
    }
}
