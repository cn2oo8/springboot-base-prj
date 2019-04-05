package com.shareyi.basespringboot.common.utils;

import com.shareyi.basespringboot.common.web.CommonResult;

/**
 * 结果工具类
 *
 * @author david
 * @date 2018/9/1
 */
public class ResultUtils {

    /**
     * 传递结果集
     *
     * @param local
     * @param remote
     * @return
     */
    public static CommonResult passResult(CommonResult local, CommonResult remote) {
        if (local == null) {
            local = new CommonResult();
        }
        return local.setResultInfo(remote.isSuccess(), remote.getMessage(), remote.getReturnCode());
    }
}
