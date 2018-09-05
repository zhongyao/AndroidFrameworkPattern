package com.hongri.model.mvp.model;

import com.hongri.model.mvp.model.base.MVPBaseModel;

/**
 * @author zhongyao
 * @date 2018/9/5
 *
 * 统一Model管理器
 */

public class MVPModelManager {

    public static MVPBaseModel mvpModel;

    public static MVPBaseModel newInstance(String modelName) {

        try {
            mvpModel = (MVPBaseModel)Class.forName(modelName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mvpModel;
    }
}
