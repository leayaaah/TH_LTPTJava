/*
 * @ (#) Ex2        1.0     1/16/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package baitap.ex2;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 1/16/2026  3:03 AM
 */
class MyTask implements Runnable {
    @Override
    public void run() {
        try{
           Thread t1 = new Thread(new AnotherTask("AnotherTask",10));
            t1.start();
            for (int i = 0; i < 8; i++) {
                System.out.println("MyTask " + i);
                if (i == 4) {
                    t1.join();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class AnotherTask implements Runnable {
    private String taskName;
    private int count;

    public AnotherTask(String taskName, int count) {
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
public class Ex2 {
    public static void main(String[] args) throws Exception {
        new Thread(new MyTask()).start();
    }
}

