package com.study.sky.salarypaymentsystem.model.transaction.beantransaction;

import com.study.sky.salarypaymentsystem.model.DbManager;
import com.study.sky.salarypaymentsystem.model.Employee;
import com.study.sky.salarypaymentsystem.model.affiliation.Affiliation;
import com.study.sky.salarypaymentsystem.model.affiliation.UnionAffiliation;
import com.study.sky.salarypaymentsystem.model.bean.ServiceCharge;
import com.study.sky.salarypaymentsystem.model.bean.SimpleDate;
import com.study.sky.salarypaymentsystem.model.transaction.Transaction;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/13.
 */

public class AddServiceChargeTransaction implements Transaction {
    private long mMemberId;
    private SimpleDate mDate;
    private double mServiceCharge;

    public AddServiceChargeTransaction(long memberId, SimpleDate date, double serviceCharge) {
        mMemberId = memberId;
        mDate = date;
        mServiceCharge = serviceCharge;
    }

    @Override
    public void execute() {
        Employee e = DbManager.getInstance().getEmployeeByMemberId(mMemberId);
        ServiceCharge charg = new ServiceCharge(mDate, mServiceCharge);

        Affiliation affiliation = e.getAffiliation();
        if(affiliation instanceof UnionAffiliation){
            ((UnionAffiliation)affiliation).addServiceCharge(charg);
        }
    }
}
