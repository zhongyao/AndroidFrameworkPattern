package com.hongri.model.mvp.view;

/**
 * @author zhongyao
 * @date 2018/9/3
 */

public interface MVPViewInterface {
    /**
     * 数据处理完成后，调用此方法更新UI
     * @param name
     */
    void showData(String name);
}
