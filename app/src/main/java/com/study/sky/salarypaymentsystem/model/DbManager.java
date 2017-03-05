package com.study.sky.salarypaymentsystem.model;

import java.util.concurrent.ConcurrentHashMap;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/6.
 */

public class DbManager {
    private static DbManager instance = new DbManager();

    public static DbManager getInstance() {
        return instance;
    }

    public Employee getEmployeeById(long id) {
        return employees.get(id);
    }

    private ConcurrentHashMap<Long, Employee> employees = new ConcurrentHashMap<>();

    public void addEmployee(long id, Employee e) {
        employees.put(id, e);
    }
}
