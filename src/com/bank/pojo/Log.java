package com.bank.pojo;

public class Log {
    private int id;
    private String accout;
    private String accin;
    private double money;

    public Log(){}

    public Log(int id, String accout, String accin, double money) {
        this.id = id;
        this.accout = accout;
        this.accin = accin;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccout() {
        return accout;
    }

    public void setAccout(String accout) {
        this.accout = accout;
    }

    public String getAccin() {
        return accin;
    }

    public void setAccin(String accin) {
        this.accin = accin;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
