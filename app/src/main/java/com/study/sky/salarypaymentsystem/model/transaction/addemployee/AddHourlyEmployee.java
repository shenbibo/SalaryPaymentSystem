package com.study.sky.salarypaymentsystem.model.transaction.addemployee;

import com.study.sky.salarypaymentsystem.model.classification.HourlyClassification;
import com.study.sky.salarypaymentsystem.model.classification.PaymentClassification;
import com.study.sky.salarypaymentsystem.model.schedule.PaymentSchedule;
import com.study.sky.salarypaymentsystem.model.schedule.WeeklySchedule;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/6.
 */

public class AddHourlyEmployee extends AddEmployeeTransaction {
    private double hourlyPay;
    public AddHourlyEmployee(long id, String name, String address, double hourPay) {
        super(id, name, address);
        hourlyPay = hourPay;
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new HourlyClassification(hourlyPay);
    }
}
