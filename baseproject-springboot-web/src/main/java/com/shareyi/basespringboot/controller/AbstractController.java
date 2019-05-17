package com.shareyi.basespringboot.controller;

import com.shareyi.basespringboot.common.web.PageQuery;
import com.shareyi.basespringboot.domain.BasicDomain;
import com.shareyi.basespringboot.service.BaseService;
import com.shareyi.basespringboot.web.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 抽象的基础controller
 *
 * @author david
 * @date 2018/8/21
 */
public abstract class AbstractController<T extends BasicDomain> extends BaseController {


    /**
     * 基础新增服务
     * @param t
     * @return
     */
    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map add(T t) {
        return getService().add(t).getReturnMap();
    }

    /**
     * 基础更新服务
     * @param t
     * @return
     */
    @RequestMapping(value = "update", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map update(T t) {
        return getService().update(t).getReturnMap();
    }

    /**
     * 基础删除服务
     * @param primaryKey
     * @return
     */
    @RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map delete(Long primaryKey) {
        return getService().deleteByPk(primaryKey).getReturnMap();
    }

    /**
     * 基础主键获取服务
     * @param primaryKey
     * @return
     */
    @RequestMapping(value = "getByPk", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map getByPk(Long primaryKey) {
        return getService().getByPk(primaryKey).getReturnMap();
    }

    /**
     * 基础分页查询服务
     * @param request
     * @return
     */
    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map queryByPage(HttpServletRequest request) {
        PageQuery pageQuery = new PageQuery(request, this.getPageSize(request));
        return getService().queryByPage(pageQuery).getReturnMap();
    }

    /**
     * 基础服务
     *
     * @return
     */
    public abstract BaseService getService();

}
