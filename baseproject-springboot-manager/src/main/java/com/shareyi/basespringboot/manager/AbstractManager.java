package com.shareyi.basespringboot.manager;


import com.shareyi.basespringboot.builder.BaseBuilder;
import com.shareyi.basespringboot.domain.BasicDomain;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 普通的非SDK版本 manager，仅仅用于操作数据库
 * </p>
 *
 * @author david
 * @date 2018-08-03
 */
public abstract class AbstractManager<T extends BasicDomain>
        implements BaseManager<T> {

    /***
     * 根据id，获取到明细
     * @param id
     * @return
     */
    @Override
    public T getByPk(Long id) {
        T t = getDao().getByPk(id);
        return t;
    }


    /***
     * 条件查询
     * 防止未设置分页信息，SQL报错
     * @param params
     * @return
     */
    @Override
    public List<T> queryByPage(Map<String, Object> params) {
        if (!params.containsKey("startIndex")) {
            params.put("startIndex", 0);
        }
        if (!params.containsKey("pageSize")) {
            params.put("pageSize", 10);
        }
        List<T> list = getDao().queryByPage(params);
        return list;
    }

    /***
     * 查询行数
     * @param params
     * @return
     */
    @Override
    public Long count(Map<String, Object> params) {
        return getDao().count(params);
    }

    /***
     * 修改数据
     * @param t
     * @return
     */
    @Override
    public int update(T t) {
        int count = getDao().update(t);
        return count;
    }


    /***
     * 添加数据
     * @param t
     * @return
     */
    @Override
    public Long add(T t) {
        getDao().add(t);
        return t.getId();
    }

    /***
     * 批量 添加数据
     * @param list
     * @return
     */
    @Override
    public int batchAdd(List<T> list) {
        return getDao().batchAdd(list);
    }


    /**
     * 物理删除，仅供测试清理数据
     */
    @Override
    public int deleteByPk(Long id) {
        return getDao().deleteByPk(id);
    }

    /**
     *
     */
    /***
     * 条件查询,最大1000条
     * @param queryBean
     * @return
     */
    @Override
    public List<T> getListByExample(T queryBean) {
        return getDao().getListByExample(getBuilder().buildQueryMap(queryBean));
    }

    public abstract BaseBuilder<T> getBuilder();
}
