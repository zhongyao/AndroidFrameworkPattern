package com.hongri.model.mvp.bean;

/**
 * @author zhongyao
 * @date 2018/9/6
 */

public class MVPDataInfo {

    private String mName;
    private String mGender;
    private int mAge;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }
    @Override
    public String toString() {
        return "MVPDataInfo{" +
            "mName='" + mName + '\'' +
            ", mGender='" + mGender + '\'' +
            ", mAge=" + mAge +
            '}';
    }
}
