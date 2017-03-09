package com.study.sky.salarypaymentsystem.model.transaction.beantransaction;

import com.study.sky.salarypaymentsystem.model.DbManager;
import com.study.sky.salarypaymentsystem.model.Employee;
import com.study.sky.salarypaymentsystem.model.bean.HourlyTimeCard;
import com.study.sky.salarypaymentsystem.model.bean.SimpleDate;
import com.study.sky.salarypaymentsystem.model.classification.HourlyClassification;
import com.study.sky.salarypaymentsystem.model.transaction.Transaction;

import java.util.Date;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/10.
 */

public class AddTimeCardTransaction implements Transaction{
    private SimpleDate mDate;
    private double mHours;
    private long mId;

    public AddTimeCardTransaction(SimpleDate date, double hours, long id) {
        mDate = date;
        mHours = hours;
        mId = id;
    }

    @Override
    public void execute() {
        Employee e = DbManager.getInstance().getEmployeeById(mId);
        HourlyClassification hourlyClassification = (HourlyClassification) e.getPaymentClassification();

        HourlyTimeCard timeCard = new HourlyTimeCard(mDate, mHours);
        hourlyClassification.addTimeCard(timeCard);
    }
}
