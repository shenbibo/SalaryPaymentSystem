package com.study.sky.salarypaymentsystem.model.classification;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/8.
 */

public class CommissionedClassification implements PaymentClassification{
    private double basicMonthlyPay;

    public CommissionedClassification(double basicMonthlyPay){
        this.basicMonthlyPay = basicMonthlyPay;
    }

    public double getBasicMonthlyPay() {
        return basicMonthlyPay;
    }
}
