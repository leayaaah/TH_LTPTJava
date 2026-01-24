/*
 * @ (#) Ex15        1.0     1/16/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package baitap.ex1;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 1/16/2026  2:58 AM
 */
class MyTask4 implements Runnable {
    private int x;
    public MyTask4(Integer x) {
        this.x = x;
    }
    private boolean checkPrime(Integer n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    @Override
    public void run() {
        for (int i = 1; i <= x; i++) {
           if (checkPrime(i)) {
               System.out.println(i + " is a prime number.");
           }
        }
    }
}
public class Ex15 {
    public static void main(String[] args) {
        int n = 20;
        Runnable task = new MyTask4(n);
        Thread thread = new Thread(task);
        thread.start();
    }

}

