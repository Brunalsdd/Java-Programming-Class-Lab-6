package com.example.demo;

public class AccountTest {
    public static AccountTest account;
    private static int balance = 2000;
    private static Person person;

    private AccountTest() {
    }

    public static AccountTest getAccount(Person p) {
        if (account == null) {
            account = new AccountTest();
        }
        AccountTest.person = p;
        return account;
    }

    public static int getBal() {
        return balance;
    }

    public synchronized void withdraw(int bal) {
        try {

            if (balance >= bal) {
                System.out.println(person.getName() + " " + "is trying to withdraw");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance = balance - bal;
                System.out.println(person.getName() + " " + "completed the withdraw");
            } else {
                System.out.println(person.getName() + " " + "doesn't have enough money to withdraw ");
            }
            System.out.println(person.getName() + " " + " withdrew Rs" + bal + " Current balance: Rs" + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(int bal) {
        try {
            if (bal > 0) {
                System.out.println(person.getName() + " " + " is tryig to deposit");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance = balance + bal;
                System.out.println(person.getName() + " " + " completed the deposit");
            } else {
                System.out.println(person.getName() + " " + "doesn't have enough money to deposit");
            }
            System.out.println(person.getName() + " " + " deposited Rs" + bal + " Current balance: Rs" + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}