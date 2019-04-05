package com.shareyi.basespringboot.validate;


import com.shareyi.basespringboot.common.exception.AutoCodeException;
import com.shareyi.basespringboot.domain.BasicDomain;

/**
 * <p> </p>
 *
 * @author david
 * @created 2017-09-26 11:55
 */
public interface BaseValidator<T extends BasicDomain> {
    /***
     * 添加数据时的校验
     * @param obj
     * @throws AutoCodeException 如果校验不通过，则抛出异常
     */
    void addValid(T obj) throws AutoCodeException;

    /***
     * 修改数据时的数据校验
     * @param obj
     * @throws AutoCodeException 如果校验不通过，则抛出异常
     */
    void updateValid(T obj) throws AutoCodeException;

    /**
     * 查询参数验证
     *
     * @param obj
     */
    void queryValid(T obj);

    /**
     * 删除验证
     *
     * @param primaryKey
     */
    void deleteValid(Long primaryKey);
}
