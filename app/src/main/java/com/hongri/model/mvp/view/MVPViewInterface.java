package com.hongri.model.mvp.view;

import com.hongri.model.mvp.view.base.MVPBaseViewInterface;

/**
 * @author zhongyao
 * @date 2018/9/4
 */

public interface MVPViewInterface extends MVPBaseViewInterface {

    /**
     * 数据处理完成后，调用此方法更新UI
     *
     * @param name
     */
    void showData(String name);
}
