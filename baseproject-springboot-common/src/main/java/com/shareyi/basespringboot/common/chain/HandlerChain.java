package com.shareyi.basespringboot.common.chain;

/**
 * handlerChain
 *
 * @author zhangshibin
 * @date 2019/4/5
 */
public interface HandlerChain<T> {
    /**
     * 执行处理
     *
     * @param context
     * @throws Exception
     */
    void handle(T context) throws Exception;
}
