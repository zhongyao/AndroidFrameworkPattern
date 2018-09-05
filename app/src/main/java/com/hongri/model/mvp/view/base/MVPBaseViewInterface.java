package com.hongri.model.mvp.view.base;

/**
 * @author zhongyao
 * @date 2018/9/3
 *
 * 该接口记录所有页面通用的回调方法
 */

public interface MVPBaseViewInterface {

    /**
     * 展示通用页面Loading
     */
    void showLoading();

    /**
     * 取消通用页面Loading
     */
    void dismissLoading();
}
