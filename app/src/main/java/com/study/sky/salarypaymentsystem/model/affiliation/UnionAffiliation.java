package com.study.sky.salarypaymentsystem.model.affiliation;

import com.study.sky.salarypaymentsystem.model.bean.ServiceCharge;
import com.study.sky.salarypaymentsystem.model.bean.SimpleDate;

import java.util.concurrent.ConcurrentHashMap;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/13.
 */

public class UnionAffiliation implements Affiliation {
    private long mMemberId;
    private double mDues;
    private ConcurrentHashMap<SimpleDate, ServiceCharge> serviceCharges = new ConcurrentHashMap<>();

    public UnionAffiliation(long memberId, double dues) {
        mMemberId = memberId;
        mDues = dues;
    }

    public long getMemberId() {
        return mMemberId;
    }

    public double getDues() {
        return mDues;
    }

    public void addServiceCharge(ServiceCharge serviceCharge) {
        serviceCharges.put(serviceCharge.getDate(), serviceCharge);
    }

    public ServiceCharge getServiceCharge(SimpleDate date) {
        return serviceCharges.get(date);
    }
}
