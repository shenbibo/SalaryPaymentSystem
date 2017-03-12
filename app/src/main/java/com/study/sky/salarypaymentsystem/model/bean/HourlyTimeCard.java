package com.study.sky.salarypaymentsystem.model.bean;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/5.
 */

public class HourlyTimeCard {
    private SimpleDate mDate;
    private double mHours;

    public HourlyTimeCard(SimpleDate date, double hours) {
        mDate = date;
        mHours = hours;
    }

    public SimpleDate getDate() {
        return mDate;
    }

    public double getHour() {
        return mHours;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SalesReceipt) {
            if (obj == this) {
                return true;
            }

            HourlyTimeCard temp = (HourlyTimeCard) obj;
            if (temp.mHours == mHours && temp.mDate.equals(mDate)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return mDate.hashCode() + Double.valueOf(mHours).hashCode();
    }
}
