package com.study.sky.salarypaymentsystem;

import com.study.sky.salarypaymentsystem.model.Employee;
import com.study.sky.salarypaymentsystem.model.bean.HourlyTimeCard;
import com.study.sky.salarypaymentsystem.model.bean.SimpleDate;
import com.study.sky.salarypaymentsystem.model.classification.HourlyClassification;
import com.study.sky.salarypaymentsystem.model.classification.PaymentClassification;
import com.study.sky.salarypaymentsystem.model.transaction.beantransaction.AddTimeCardTransaction;

import org.junit.Test;

import java.util.Date;

import utils.EmployeeUtils;

import static org.junit.Assert.*;
/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/10.
 */

public class AddTimeCardTest {

    @Test
    public void addOneTimeCardTest(){
        Employee e = EmployeeUtils.createDefaultHourlyEmployee();

        SimpleDate date = new SimpleDate(new Date(2017, 2, 10));
        AddTimeCardTransaction timeCardTransaction = new AddTimeCardTransaction(date, 7.0, e.getId());
        timeCardTransaction.execute();

        HourlyClassification hourlyClassification = (HourlyClassification) e.getPaymentClassification();
        HourlyTimeCard timeCard = hourlyClassification.getTimeCard(date);

        assertEquals(date, timeCard.getDate());
        assertEquals(7.0, timeCard.getHour(), 0.01);
    }
}
