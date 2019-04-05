package com.shareyi.basespringboot.common.chain.handler;

import com.shareyi.basespringboot.common.chain.HandlerChain;

/**
 * handler 处理器
 *
 * @author zhangshibin
 * @date 2019/4/5
 */
public interface Handler<T> {
    /**
     * 执行处理
     *
     * @param context
     * @param handlerChain
     * @throws Exception
     */
    void handle(T context, HandlerChain<T> handlerChain) throws Exception;
}
