package com.study.sky.salarypaymentsystem.model.bean;

/**
 * [销售凭据]
 * [详述类的功能。]
 * Created by sky on 2017/3/5.
 */

public class SalesReceipt {
    private SimpleDate mDate;
    private int mAmount;

    public SalesReceipt(SimpleDate date, int amount) {
        mDate = date;
        mAmount = amount;
    }

    public SimpleDate getDate() {
        return mDate;
    }

    public int getAmount() {
        return mAmount;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof SalesReceipt) {
//            if (obj == this) {
//                return true;
//            }
//
//            SalesReceipt temp = (SalesReceipt) obj;
//            if (temp.mAmount == mAmount && temp.mDate.equals(mDate)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return mDate.hashCode() + Integer.valueOf(mAmount).hashCode();
//    }
}
