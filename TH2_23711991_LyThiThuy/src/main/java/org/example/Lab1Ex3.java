/*
 * @ (#) Lab1Ex3        1.0     1/25/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package org.example;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 1/25/2026  7:12 AM
 */
public class Lab1Ex3{

    class BankAccount {
        private double balance = 0;
        private final Object lock = new Object();
        private static final double LIMIT = 100_000;

        // Deposit với giới hạn và chờ nếu vượt mức
        public void deposit(double amount) throws InterruptedException {
            synchronized (lock) {
                while (balance + amount > LIMIT) {
                    System.out.println(Thread.currentThread().getName()
                            + " waiting deposit Balance = " + balance);
                    lock.wait();
                }
                balance += amount;
                System.out.println(Thread.currentThread().getName()
                        + " deposited " + amount + ", Balance = " + balance);
                lock.notifyAll();
            }
        }

        // Withdraw và chờ nếu không đủ tiền
        public void withdraw(double amount) throws InterruptedException {
            synchronized (lock) {
                while (balance < amount) {
                    System.out.println(Thread.currentThread().getName()
                            + " waiting withdraw Balance = " + balance);
                    lock.wait();
                }
                balance -= amount;
                System.out.println(Thread.currentThread().getName()
                        + " withdraw " + amount + ", Balance = " + balance);
                lock.notifyAll();
            }
        }
    }

    // Luồng nạp tiền
    class DepositTask implements Runnable {
        private BankAccount account;

        public DepositTask(BankAccount account) {
            this.account = account;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    account.deposit(100);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Luồng rút tiền
    class WithdrawTask implements Runnable {
        private BankAccount account;

        public WithdrawTask(BankAccount account) {
            this.account = account;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    account.withdraw(100);
                    Thread.sleep(15);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void execute() {
        BankAccount account = new BankAccount();

        for (int i = 0; i < 2; i++) {
            new Thread(new DepositTask(account), "Deposit-" + i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(new WithdrawTask(account), "Withdraw-" + i).start();
        }

    }

    public static void main(String[] args) {
        Lab1Ex3 lab = new Lab1Ex3();
        lab.execute();
    }
}

