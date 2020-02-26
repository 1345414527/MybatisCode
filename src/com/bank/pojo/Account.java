package com.bank.pojo;

public class Account {
    private int id;
    private String accNo;
    private int password;
    private String name;
    private double balance;

    public Account(){};

    public Account(int id, String accNo, int password, String name, double balance) {
        this.id = id;
        this.accNo = accNo;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
