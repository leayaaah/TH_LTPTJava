/*
 * @ (#) Ex12        1.0     1/16/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package baitap.ex1;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 1/16/2026  2:43 AM
 */
class MyTask1 extends Thread {
    private String taskName;
    private int count;

    public MyTask1(String taskName, int count) {
        super();
        this.taskName = taskName;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(taskName + i);
        }
    }
}
public class Ex12 {
    public static void main(String[] args) {
        Thread t1 = new MyTask1("task 1: ", 5);
        Thread t2 = new MyTask1("task 2: ", 10);
        t1.start();
        t2.start();
    }
}

