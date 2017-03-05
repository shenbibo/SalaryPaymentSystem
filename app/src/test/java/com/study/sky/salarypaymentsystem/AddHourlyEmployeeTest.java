package com.study.sky.salarypaymentsystem;



import com.study.sky.salarypaymentsystem.model.DbManager;
import com.study.sky.salarypaymentsystem.model.Employee;
import com.study.sky.salarypaymentsystem.model.classification.HourlyClassification;
import com.study.sky.salarypaymentsystem.model.transaction.addemployee.AddHourlyEmployee;

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

public class AddHourlyEmployeeTest {

    @BeforeClass
    public static void init(){}

    @AfterClass
    public static void release(){}

    // 使用before注释的方法在每个测试用例执行之前都会执行一次
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @After
    public void tearDown(){

    }

    @Test
    public void addHourlyEmployee(){
        long id = 123L;
        String name = "sky";
        String address = "sky.home";
        double hourPay = 150.28;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(id, name, address, hourPay);
        addHourlyEmployee.execute();

        DbManager dbManager = DbManager.getInstance();

        Employee e = dbManager.getEmployeeById(id);
        assertNotNull(e);
        assertEquals(id, e.getId());
        assertEquals(name, e.getName());
        assertEquals(address, e.getAddress());

        HourlyClassification classification = (HourlyClassification) e.getPaymentClassification();
        assertEquals(hourPay, classification.getHourlyPay(), 0.01);

        assertNotNull(e.getPaymentMethod());
        assertNotNull(e.getPaymentSchedule());
    }
}
