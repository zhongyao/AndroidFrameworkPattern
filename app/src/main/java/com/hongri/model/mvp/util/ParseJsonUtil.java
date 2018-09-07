package com.hongri.model.mvp.util;

import com.hongri.model.mvp.bean.MVPDataInfo;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author zhongyao
 * @date 2018/9/6
 *
 * Json数据解析类
 */

public class ParseJsonUtil {

    public static MVPDataInfo parseJSONData(String data) {
        MVPDataInfo dataInfo = new MVPDataInfo();
        try {
            JSONObject jsonObject = new JSONObject(data);
            dataInfo.setmName(jsonObject.optString("mData"));
            dataInfo.setmGender(jsonObject.optString("gender"));
            dataInfo.setmAge(jsonObject.optInt("age"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataInfo;
    }
}
