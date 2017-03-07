package com.study.sky.salarypaymentsystem.model.classification;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/8.
 */

public class MonthlyClassification implements PaymentClassification {
    private double monthlyPay;
    public MonthlyClassification(double monthlyPay){
        this.monthlyPay = monthlyPay;
    }

    public double getMonthlyPay() {
        return monthlyPay;
    }
}
