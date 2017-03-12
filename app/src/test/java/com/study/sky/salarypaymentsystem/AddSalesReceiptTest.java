package com.study.sky.salarypaymentsystem;

import com.study.sky.salarypaymentsystem.model.Employee;
import com.study.sky.salarypaymentsystem.model.bean.SalesReceipt;
import com.study.sky.salarypaymentsystem.model.bean.SimpleDate;
import com.study.sky.salarypaymentsystem.model.classification.CommissionedClassification;
import com.study.sky.salarypaymentsystem.model.transaction.beantransaction.AddSalesReceiptTransaction;

import org.junit.Test;

import java.util.Date;

import utils.EmployeeFactory;

import static org.junit.Assert.*;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/12.
 */

public class AddSalesReceiptTest {

    @Test
    public void addOneSalesReceipt() {
        Employee e = EmployeeFactory.createDefaultCommissionedEmployee();
        SimpleDate date = new SimpleDate(new Date(2017, 2, 12));
        int amount = 3;

        AddSalesReceiptTransaction transaction = new AddSalesReceiptTransaction(date, amount, e.getId());
        transaction.execute();

        CommissionedClassification classification = (CommissionedClassification) e.getPaymentClassification();

        SalesReceipt salesReceipt = classification.getSalesReceipt(date);

        assertEquals(date, salesReceipt.getDate());
        assertEquals(3, salesReceipt.getAmount());
    }
}
