package com.shareyi.basespringboot.common.chain.handler;

/**
 * 责任链感应器，用于感应责任链列表
 *
 * @author david
 * @date 2018/8/7
 */
public interface HandlerAware {

    /**
     * 获取顺序，以此来进行排序
     *
     * @return
     */
    int getOrder();

}
