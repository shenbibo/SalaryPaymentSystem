package com.study.sky.salarypaymentsystem.model.bean;

import java.util.Date;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/10.
 */

public class SimpleDate {
    private Date mDate;

    public SimpleDate(Date date) {
        mDate = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SimpleDate) {
            Date objDate = ((SimpleDate) obj).mDate;
            if (mDate.getYear() == objDate.getYear() && mDate.getMonth() == objDate.getMonth()
                    && mDate.getDate() == objDate.getDate()) {
                return true;
            }
        }
        return false;
    }
}
