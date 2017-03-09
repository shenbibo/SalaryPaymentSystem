package utils;

import com.study.sky.salarypaymentsystem.model.DbManager;
import com.study.sky.salarypaymentsystem.model.Employee;
import com.study.sky.salarypaymentsystem.model.transaction.addemployee.AddHourlyEmployee;

/**
 * [用于创建测试使用的对象]
 * [详述类的功能。]
 * Created by sky on 2017/3/10.
 */

public class EmployeeUtils {

    public static Employee createDefaultHourlyEmployee(){
        long id = 123L;
        String name = "sky";
        String address = "sky.home";
        double hourPay = 150.28;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(id, name, address, hourPay);
        addHourlyEmployee.execute();

        return DbManager.getInstance().getEmployeeById(id);
    }
}
