package com.hongri.model.mvp.model;

import com.hongri.model.mvp.model.base.MVPBaseModel;

/**
 * @author zhongyao
 * @date 2018/9/5
 */

public class MVPDataModel {

    public static MVPBaseModel mvpModel;

    public static MVPBaseModel request(String modelName) {

        try {
            mvpModel = (MVPBaseModel)Class.forName(modelName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mvpModel;
    }
}
