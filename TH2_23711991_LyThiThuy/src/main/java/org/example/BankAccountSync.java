/*
 * @ (#) BankAccountSync        1.0     1/25/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package org.example;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 1/25/2026  8:34 AM
 */
class BankAccountSync {
    private double balance = 0;
    private static final double LIMIT = 100_000;

    public synchronized void deposit(double amount) throws InterruptedException {
        while (balance + amount > LIMIT) {
            wait();
        }
        balance += amount;
        System.out.println(Thread.currentThread().getName() +
                " deposit " + amount + ", Balance = " + balance);
        notifyAll();
    }

    public synchronized void withdraw(double amount) throws InterruptedException {
        while (balance < amount) {
            wait();
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() +
                " withdraw " + amount + ", Balance = " + balance);
        notifyAll();
    }
}

// Task
class DepositTaskSync implements Runnable {
    private BankAccountSync acc;
    public DepositTaskSync(BankAccountSync acc) { this.acc = acc; }

    public void run() {
        try {
            for (int i = 0; i < 20; i++) acc.deposit(100);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

class WithdrawTaskSync implements Runnable {
    private BankAccountSync acc;
    public WithdrawTaskSync(BankAccountSync acc) { this.acc = acc; }

    public void run() {
        try {
            for (int i = 0; i < 20; i++) acc.withdraw(100);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

// demo
class BankAccountSyncDemo {
    public static void main(String[] args) {
        BankAccountSync acc = new BankAccountSync();
        for (int i = 0; i < 3; i++) {
            new Thread(new DepositTaskSync(acc), "Deposit" + i).start();
            new Thread(new WithdrawTaskSync(acc), "Withdraw" + i).start();
        }
    }
}
