package com.study.sky.salarypaymentsystem.model.transaction.beantransaction;

import com.study.sky.salarypaymentsystem.model.DbManager;
import com.study.sky.salarypaymentsystem.model.Employee;
import com.study.sky.salarypaymentsystem.model.bean.SalesReceipt;
import com.study.sky.salarypaymentsystem.model.bean.SimpleDate;
import com.study.sky.salarypaymentsystem.model.classification.CommissionedClassification;
import com.study.sky.salarypaymentsystem.model.transaction.Transaction;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/12.
 */

public class AddSalesReceiptTransaction implements Transaction{
    private SimpleDate mDate;
    private int mAmount;
    private long mId;

    public AddSalesReceiptTransaction(SimpleDate date, int amount, long id){
        mDate = date;
        mAmount = amount;
        mId = id;
    }

    @Override
    public void execute() {
        SalesReceipt salesReceipt = new SalesReceipt(mDate, mAmount);
        Employee e = DbManager.getInstance().getEmployeeById(mId);
        CommissionedClassification classification = (CommissionedClassification) e.getPaymentClassification();
        classification.addSalesReceipt(salesReceipt);
    }
}
