package com.study.sky.salarypaymentsystem.model.classification;

import com.study.sky.salarypaymentsystem.model.bean.SalesReceipt;
import com.study.sky.salarypaymentsystem.model.bean.SimpleDate;

import java.util.concurrent.ConcurrentHashMap;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/8.
 */

public class CommissionedClassification implements PaymentClassification {
    private double basicMonthlyPay;
    private ConcurrentHashMap<SimpleDate, SalesReceipt> salesReceipts = new ConcurrentHashMap<>();

    public double getCommissionRate() {
        return commissionRate;
    }

    private double commissionRate;

    public CommissionedClassification(double basicMonthlyPay, double commissionRate) {
        this.basicMonthlyPay = basicMonthlyPay;
        this.commissionRate = commissionRate;
    }

    public double getBasicMonthlyPay() {
        return basicMonthlyPay;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceipts.put(salesReceipt.getDate(), salesReceipt);
    }

    public SalesReceipt getSalesReceipt(SimpleDate date) {
        return salesReceipts.get(date);
    }
}
