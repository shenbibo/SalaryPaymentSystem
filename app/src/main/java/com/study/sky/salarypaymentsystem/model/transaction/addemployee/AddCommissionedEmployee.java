package com.study.sky.salarypaymentsystem.model.transaction.addemployee;

import com.study.sky.salarypaymentsystem.model.classification.CommissionedClassification;
import com.study.sky.salarypaymentsystem.model.classification.PaymentClassification;
import com.study.sky.salarypaymentsystem.model.schedule.BiweeklySchedule;
import com.study.sky.salarypaymentsystem.model.schedule.PaymentSchedule;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/8.
 */

public class AddCommissionedEmployee extends AddEmployeeTransaction{
    private double basicMonthlyPay;
    public AddCommissionedEmployee(long id, String name, String address, double basicMonthlyPay) {
        super(id, name, address);
        this.basicMonthlyPay = basicMonthlyPay;
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new CommissionedClassification(basicMonthlyPay);
    }
}
