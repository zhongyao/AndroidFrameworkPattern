package com.hongri.model.mvp.util;

import com.hongri.model.mvp.bean.MVPDataInfo;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author zhongyao
 * @date 2018/9/5
 */

public class ParseJsonUtil {

    public static MVPDataInfo parseJSONData(String data) {
        MVPDataInfo dataInfo = new MVPDataInfo();
        try {
            JSONObject jsonObject = new JSONObject(data);
            dataInfo.setmName(jsonObject.getString("name"));
            dataInfo.setmAge(jsonObject.getInt("age"));
            dataInfo.setmGender(jsonObject.getString("gender"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataInfo;
    }
}
