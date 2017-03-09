package com.study.sky.salarypaymentsystem.model.classification;

import com.study.sky.salarypaymentsystem.model.bean.HourlyTimeCard;
import com.study.sky.salarypaymentsystem.model.bean.SimpleDate;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2017/3/6.
 */

public class HourlyClassification implements PaymentClassification {
    private double hourlyPay;
    private ConcurrentHashMap<SimpleDate, HourlyTimeCard> cards = new ConcurrentHashMap<>();
    public HourlyClassification(double hourlyPay){
        this.hourlyPay = hourlyPay;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public HourlyTimeCard getTimeCard(SimpleDate date) {
        return cards.get(date);
    }

    public void addTimeCard(HourlyTimeCard card){
        cards.put(card.getDate(), card);
    }
}
