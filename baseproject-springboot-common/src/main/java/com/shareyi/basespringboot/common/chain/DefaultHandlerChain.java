package com.shareyi.basespringboot.common.chain;

import com.shareyi.basespringboot.common.chain.handler.Handler;

import java.util.List;

public class DefaultHandlerChain<T> implements HandlerChain<T> {
    /**
     * 责任链列表
     */
    private final List<? extends Handler<T>> handlers;
    /**
     * 责任链当前下标
     */
    private int index = 0;

    /**
     * 构建器
     *
     * @param handlers
     */
    public DefaultHandlerChain(List<? extends Handler<T>> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void handle(T t) throws Exception {
        Handler<T> next = this.getNext();
        if (next != null) {
            next.handle(t, this);
        }

    }

    /**
     * 获取下一个
     *
     * @return
     */
    protected Handler<T> getNext() {
        return this.handlers != null && this.index < this.handlers.size() ? this.handlers.get(this.index++) : null;
    }
}
