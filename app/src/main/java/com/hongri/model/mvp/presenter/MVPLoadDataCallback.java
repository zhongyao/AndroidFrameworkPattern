package com.hongri.model.mvp.presenter;

import android.graphics.Bitmap;

/**
 * @author zhongyao
 * @date 2018/9/3
 */

public interface MVPLoadDataCallback {
    /**
     * 这里引入泛型的概念--可以根据请求数据类型的不同设置为不同类型的参数
     *
     * @param successData
     */
    void onSuccess(String successData);

    void onFailure(String errorData);

    /**
     * 业务方获取（图片）成功
     */
    void onSuccessBitmap(Bitmap bitmap);

    /**
     * 业务方获取（图片）失败
     */
    void onFailureBitmap(Bitmap bitmap);
}
