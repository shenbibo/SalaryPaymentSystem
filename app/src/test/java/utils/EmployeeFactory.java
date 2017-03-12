package utils;

import com.study.sky.salarypaymentsystem.model.DbManager;
import com.study.sky.salarypaymentsystem.model.Employee;
import com.study.sky.salarypaymentsystem.model.transaction.addemployee.AddCommissionedEmployee;
import com.study.sky.salarypaymentsystem.model.transaction.addemployee.AddHourlyEmployee;
import com.study.sky.salarypaymentsystem.model.transaction.addemployee.AddSalariedEmployee;

/**
 * [用于创建测试使用的对象]
 * [详述类的功能。]
 * Created by sky on 2017/3/10.
 */

public class EmployeeFactory {

    public static Employee createDefaultHourlyEmployee() {
        long id = 123L;
        String name = "sky";
        String address = "sky.home";
        double hourPay = 150.28;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(id, name, address, hourPay);
        addHourlyEmployee.execute();

        return DbManager.getInstance().getEmployeeById(id);
    }

    public static Employee createDefaultCommissionedEmployee() {
        long id = 789L;
        String name = "gavin";
        String address = "gavin.address";
        double basicMonthlyPay = 123.0;
        double commissionRate = 5.0;

        AddCommissionedEmployee addCommissionedEmployee =
                new AddCommissionedEmployee(id, name, address, basicMonthlyPay, commissionRate);
        addCommissionedEmployee.execute();

        return DbManager.getInstance().getEmployeeById(id);
    }

    public static Employee createDefaultSalariedEmployee() {
        long id = 456L;
        String name = "smith";
        String address = "smith.home";
        double monthlyPay = 1000.0;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(id, name, address, monthlyPay);
        addSalariedEmployee.execute();

        return DbManager.getInstance().getEmployeeById(id);
    }
}
