package com.study.sky.salarypaymentsystem.model;

import java.util.concurrent.ConcurrentHashMap;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/6.
 */

public class DbManager {
    private static DbManager instance = new DbManager();
    private ConcurrentHashMap<Long, Employee> employees = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, Long> members = new ConcurrentHashMap<>();

    public static DbManager getInstance() {
        return instance;
    }

    public Employee getEmployeeById(long id) {
        return employees.get(id);
    }



    public void addEmployee(long id, Employee e) {
        employees.put(id, e);
    }

    public void deleteEmployeeById(long mId) {
        employees.remove(mId);
    }

    public Employee getEmployeeByMemberId(long memberId) {
        return employees.get(members.get(memberId));
    }

    public void addUnionMember(long memberId, Employee e){
        members.put(memberId, e.getId());
    }
}
