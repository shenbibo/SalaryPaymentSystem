package com.study.sky.salarypaymentsystem.model.transaction.deleteemployee;

import com.study.sky.salarypaymentsystem.model.DbManager;
import com.study.sky.salarypaymentsystem.model.transaction.Transaction;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/8.
 */

public class DeleteEmployeeTransaction implements Transaction{
    private long mId;
    public DeleteEmployeeTransaction(long id) {
        mId = id;
    }

    @Override
    public void execute() {
        DbManager.getInstance().deleteEmployeeById(mId);
    }
}
