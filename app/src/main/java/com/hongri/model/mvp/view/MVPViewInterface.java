package com.hongri.model.mvp.view;

import com.hongri.model.mvp.view.base.MVPBaseViewInterface;

/**
 * @author zhongyao
 * @date 2018/9/4
 *
 * 记录某个业务方所需的回调方法
 */

public interface MVPViewInterface<T> extends MVPBaseViewInterface {

    /**
     * 业务方数据成功获取后，调用此方法更新UI
     *
     * @param data
     */
    void showSuccessData(T data);

    /**
     * 业务方数据获取失败后，调用此方法展示失败页面UI
     *
     * @param data
     */
    void showFailureData(T data);

    /**
     * 业务方获取（图片）成功
     */
    void showSuccessBitmap(T bitmap);

    /**
     * 业务方获取（图片）失败
     */
    void showFailureBitmap(T bitmap);

}
