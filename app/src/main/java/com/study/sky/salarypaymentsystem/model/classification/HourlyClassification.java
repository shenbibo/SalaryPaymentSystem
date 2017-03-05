package com.study.sky.salarypaymentsystem.model.classification;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/6.
 */

public class HourlyClassification implements PaymentClassification {
    private double hourlyPay;
    public HourlyClassification(double hourlyPay){
        this.hourlyPay = hourlyPay;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }
}
