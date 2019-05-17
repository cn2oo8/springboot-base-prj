package com.shareyi.basespringboot.web.base;

import com.shareyi.basespringboot.common.constants.CommonConstant;
import com.shareyi.basespringboot.common.web.CommonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础controller，其它controller可以继承本controller
 *
 * @author david
 * @date 2018-08-04
 */
public class BaseController {


    public void toVm(CommonResult result, ModelMap context) {
        this.toVm(result, context, null);
    }

    public void toVm(CommonResult result, ModelMap context, HttpServletRequest request) {
        context.putAll(result.getReturnMap());
    }

    /**
     * 获取页面传递的pageSize
     *
     * @param request
     * @return
     */
    public int getPageSize(HttpServletRequest request) {
        return getPageSize(request, CommonConstant.DEF_PAGE_SIZE, CommonConstant.MAX_PAGE_SIZE);
    }

    /**
     * 获取页面传递的pageSize
     *
     * @param request
     * @param defaultPageSize
     * @param max
     * @return
     */
    public int getPageSize(HttpServletRequest request, int defaultPageSize, int max) {
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = defaultPageSize;
        if (StringUtils.isNumeric(pageSizeStr)) {
            try {
                pageSize = Integer.valueOf(pageSizeStr);
            } catch (Exception e) {
            }
            //不能超过最大值
            pageSize = pageSize > max ? max : pageSize;
        }
        return pageSize;
    }
}
