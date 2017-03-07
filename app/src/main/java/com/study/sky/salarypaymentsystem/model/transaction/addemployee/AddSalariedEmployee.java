package com.study.sky.salarypaymentsystem.model.transaction.addemployee;

import com.study.sky.salarypaymentsystem.model.classification.MonthlyClassification;
import com.study.sky.salarypaymentsystem.model.classification.PaymentClassification;
import com.study.sky.salarypaymentsystem.model.schedule.MonthlySchedule;
import com.study.sky.salarypaymentsystem.model.schedule.PaymentSchedule;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/7.
 */

public class AddSalariedEmployee extends AddEmployeeTransaction{
    private double monthlyPay;

    public AddSalariedEmployee(long id, String name, String address, double monthlyPay){
        super(id, name, address);
        this.monthlyPay = monthlyPay;
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new MonthlyClassification(monthlyPay);
    }
}
