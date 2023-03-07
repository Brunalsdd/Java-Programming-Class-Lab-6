package com.example.demo;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transaction extends Thread implements Runnable {

    private Person person;

    public Transaction(Person p) {
        this.person = p;
    }

    public static void main(String[] args) {

        System.out.println("--------------------------------------------");
        Transaction ts1 = new Transaction(new Person("Bruna"));
        ts1.start();
        System.out.println("--------------------------------------------");
        System.out.println(" ");
        System.out.println("--------------------------------------------");
        Transaction ts2 = new Transaction(new Person("Luis"));
        ts2.start();
        System.out.println("--------------------------------------------");
        System.out.println(" ");
        System.out.println("--------------------------------------------");
        Transaction ts3 = new Transaction(new Person("Sandra"));
        ts3.start();
        System.out.println("--------------------------------------------");
        System.out.println(" ");

    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                AccountTest acc = AccountTest.getAccount(person);
                acc.withdraw(100);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (acc.getBal() < 0) {
                    System.out.println("account is overdrawn!");
                }
                acc.deposit(200);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Final Acc balance of " + person.getName() + " is Rs." + AccountTest.getBal());
    }
}