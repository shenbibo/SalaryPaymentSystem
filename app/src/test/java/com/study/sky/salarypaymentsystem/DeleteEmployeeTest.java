package com.study.sky.salarypaymentsystem;

import com.study.sky.salarypaymentsystem.model.DbManager;
import com.study.sky.salarypaymentsystem.model.transaction.deleteemployee.DeleteEmployeeTransaction;
import com.study.sky.salarypaymentsystem.model.transaction.addemployee.AddSalariedEmployee;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/8.
 */

public class DeleteEmployeeTest {
    @Test
    public void deleteEmployee(){
        long id = 789L;
        String name = "sky";
        String address = "sky.home";

        new AddSalariedEmployee(id, name, address, 10000.0).execute();

        assertNotNull(DbManager.getInstance().getEmployeeById(id));

        new DeleteEmployeeTransaction(id).execute();
        assertNull(DbManager.getInstance().getEmployeeById(id));
    }
}
