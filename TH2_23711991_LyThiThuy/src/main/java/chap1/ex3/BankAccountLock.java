/*
 * @ (#) BankAccountLock        1.0     1/25/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package chap1.ex3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 1/25/2026  8:35 AM
 */
class BankAccountLock {
    private double balance = 0;
    private static final double LIMIT = 100_000;

    private final Lock lock = new ReentrantLock();
    private final Condition enoughMoney = lock.newCondition();
    private final Condition belowLimit = lock.newCondition();

    public void deposit(double amount) throws InterruptedException {
        lock.lock();
        try {
            while (balance + amount > LIMIT) {
                belowLimit.await();
            }
            balance += amount;
            System.out.println(Thread.currentThread().getName() +
                    " deposit " + amount + " | Balance = " + balance);
            enoughMoney.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) throws InterruptedException {
        lock.lock();
        try {
            while (balance < amount) {
                enoughMoney.await();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() +
                    " withdraw " + amount + " | Balance = " + balance);
            belowLimit.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

// Task
class DepositTaskLock implements Runnable {
    private BankAccountLock acc;
    public DepositTaskLock(BankAccountLock acc) { this.acc = acc; }

    public void run() {
        try {
            for (int i = 0; i < 20; i++) acc.deposit(100);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

class WithdrawTaskLock implements Runnable {
    private BankAccountLock acc;
    public WithdrawTaskLock(BankAccountLock acc) { this.acc = acc; }

    public void run() {
        try {
            for (int i = 0; i < 20; i++) acc.withdraw(100);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

class BankAccountLockDemo {
    public static void main(String[] args) {
        BankAccountLock acc = new BankAccountLock();
        for (int i = 0; i < 3; i++) {
            new Thread(new DepositTaskLock(acc), "Deposit" + i).start();
            new Thread(new WithdrawTaskLock(acc), "Withdraw" + i).start();
        }
    }
}

