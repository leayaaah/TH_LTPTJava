/*
 * @ (#) Ex14        1.0     1/16/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package baitap.ex1;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 1/16/2026  2:56 AM
 */
class MyTask3 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}
public class Ex14 {
    public static void main(String[] args) {
        Runnable task = new MyTask3();
        Thread thread = new Thread(task);
        thread.start();
    }

}

