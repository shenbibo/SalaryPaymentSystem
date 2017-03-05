package com.study.sky.salarypaymentsystem.model.transaction.addemployee;

import com.study.sky.salarypaymentsystem.model.DbManager;
import com.study.sky.salarypaymentsystem.model.Employee;
import com.study.sky.salarypaymentsystem.model.classification.PaymentClassification;
import com.study.sky.salarypaymentsystem.model.method.HoldMethod;
import com.study.sky.salarypaymentsystem.model.schedule.PaymentSchedule;
import com.study.sky.salarypaymentsystem.model.transaction.Transaction;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/6.
 */

public abstract class AddEmployeeTransaction implements Transaction {
    protected long id;
    protected String name;
    protected String address;

    AddEmployeeTransaction(long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public void execute() {
        Employee e = new Employee(id, name, address);
        e.setPaymentSchedule(getSchedule());
        e.setPaymentClassification(getClassification());
        e.setPaymentMethod(new HoldMethod());

        DbManager dbManager = DbManager.getInstance();
        dbManager.addEmployee(id, e);

    }

    protected abstract PaymentSchedule getSchedule();

    protected abstract PaymentClassification getClassification();
}
