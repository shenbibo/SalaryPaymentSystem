package com.study.sky.salarypaymentsystem;

import com.study.sky.salarypaymentsystem.model.DbManager;
import com.study.sky.salarypaymentsystem.model.Employee;
import com.study.sky.salarypaymentsystem.model.affiliation.UnionAffiliation;
import com.study.sky.salarypaymentsystem.model.bean.ServiceCharge;
import com.study.sky.salarypaymentsystem.model.bean.SimpleDate;
import com.study.sky.salarypaymentsystem.model.transaction.beantransaction.AddServiceChargeTransaction;

import org.junit.Test;

import java.util.Date;

import utils.EmployeeFactory;

import static org.junit.Assert.*;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/13.
 */

public class AddServiceChargeTest {
    @Test
    public void addOneServiceCharge() {
        Employee e = EmployeeFactory.createDefaultSalariedEmployee();

        // TODO 一种改进其实可以直接使用employeeId 作为协会成员的Id
        long memberId = e.getId();
        // 协会费用
        double dues = 16.5;

        UnionAffiliation unionAffiliation = new UnionAffiliation(memberId, dues);
        e.setAffiliation(unionAffiliation);
        DbManager.getInstance().addUnionMember(memberId, e);

        SimpleDate date = new SimpleDate(new Date(2017, 2, 13));
        double serviceCharge = 17.2;
        AddServiceChargeTransaction transaction = new AddServiceChargeTransaction(memberId, date, serviceCharge);
        transaction.execute();

        UnionAffiliation affiliation = (UnionAffiliation) e.getAffiliation();
        ServiceCharge charge = affiliation.getServiceCharge(date);
        assertEquals(date, charge.getDate());
        assertEquals(serviceCharge, charge.getServiceCharge(), 0.01);
    }
}
