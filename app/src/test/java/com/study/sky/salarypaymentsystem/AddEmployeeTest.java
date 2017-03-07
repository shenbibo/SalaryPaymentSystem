package com.study.sky.salarypaymentsystem;


import com.study.sky.salarypaymentsystem.model.DbManager;
import com.study.sky.salarypaymentsystem.model.Employee;
import com.study.sky.salarypaymentsystem.model.affiliation.Affiliation;
import com.study.sky.salarypaymentsystem.model.classification.CommissionedClassification;
import com.study.sky.salarypaymentsystem.model.classification.HourlyClassification;
import com.study.sky.salarypaymentsystem.model.classification.MonthlyClassification;
import com.study.sky.salarypaymentsystem.model.method.HoldMethod;
import com.study.sky.salarypaymentsystem.model.schedule.BiweeklySchedule;
import com.study.sky.salarypaymentsystem.model.schedule.MonthlySchedule;
import com.study.sky.salarypaymentsystem.model.schedule.WeeklySchedule;
import com.study.sky.salarypaymentsystem.model.transaction.addemployee.AddCommissionedEmployee;
import com.study.sky.salarypaymentsystem.model.transaction.addemployee.AddHourlyEmployee;
import com.study.sky.salarypaymentsystem.model.transaction.addemployee.AddSalariedEmployee;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/6.
 */

public class AddEmployeeTest {

    private static DbManager dbManager;

    @BeforeClass
    public static void init() {
        dbManager = DbManager.getInstance();
    }

    @AfterClass
    public static void release() {
    }

    // 使用before注释的方法在每个测试用例执行之前都会执行一次
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() {

    }

    @Test
    public void addHourlyEmployee() {
        long id = 123L;
        String name = "sky";
        String address = "sky.home";
        double hourPay = 150.28;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(id, name, address, hourPay);
        addHourlyEmployee.execute();

        Employee e = dbManager.getEmployeeById(id);
        assertEmployee(e, id, name, address);

        HourlyClassification classification = (HourlyClassification) e.getPaymentClassification();
        assertEquals(hourPay, classification.getHourlyPay(), 0.01);

        assertTrue(e.getPaymentMethod() instanceof HoldMethod);
        assertTrue(e.getPaymentSchedule() instanceof WeeklySchedule);
        assertEquals(Affiliation.NO_AFFILIATION, e.getAffiliation());
    }

    @Test
    public void addSalariedEmployee() {
        long id = 456L;
        String name = "smith";
        String address = "smith.home";
        double monthlyPay = 1000.0;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(id, name, address, monthlyPay);
        addSalariedEmployee.execute();

        Employee e = dbManager.getEmployeeById(id);
        assertEmployee(e, id, name, address);

        MonthlyClassification monthlyClassification = (MonthlyClassification) e.getPaymentClassification();
        assertEquals(monthlyPay, monthlyClassification.getMonthlyPay(), 0.01);

        assertTrue(e.getPaymentMethod() instanceof HoldMethod);
        assertTrue(e.getPaymentSchedule() instanceof MonthlySchedule);
        assertEquals(Affiliation.NO_AFFILIATION, e.getAffiliation());
    }

    @Test
    public void addCommissionedEmployee() {
        long id = 789L;
        String name = "gavin";
        String address = "gavin.address";
        double basicMonthlyPay = 123.0;

        AddCommissionedEmployee addCommissionedEmployee = new AddCommissionedEmployee(id, name, address, basicMonthlyPay);
        addCommissionedEmployee.execute();

        Employee e = dbManager.getEmployeeById(id);
        assertEmployee(e, id, name, address);

        CommissionedClassification classification = (CommissionedClassification) e.getPaymentClassification();
        assertEquals(basicMonthlyPay, classification.getBasicMonthlyPay(), 0.01);

        assertTrue(e.getPaymentMethod() instanceof HoldMethod);
        assertTrue(e.getPaymentSchedule() instanceof BiweeklySchedule);
        assertEquals(Affiliation.NO_AFFILIATION, e.getAffiliation());
    }

    private void assertEmployee(Employee e, long id, String name, String address) {
        assertNotNull(e);
        assertEquals(id, e.getId());
        assertEquals(name, e.getName());
        assertEquals(address, e.getAddress());
    }

}
