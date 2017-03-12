package com.study.sky.salarypaymentsystem.model.bean;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/5.
 */

public class ServiceCharge {
    private SimpleDate mDate;
    private double mServiceCharge;

    public ServiceCharge(SimpleDate date, double serviceCharge) {
        mDate = date;
        mServiceCharge = serviceCharge;
    }

    public SimpleDate getDate() {
        return mDate;
    }

    public double getServiceCharge() {
        return mServiceCharge;
    }
}
