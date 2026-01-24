/*
 * @ (#) Ex13        1.0     1/16/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package baitap.ex1;

import java.util.concurrent.Callable;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 1/16/2026  2:49 AM
 */
class MyTask2 implements Callable<Integer> {
    private String taskName;
    private int count;

    public MyTask2(String taskName, int count) {
        super();
        this.taskName = taskName;
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        Integer result = 0;
        for (int i = 0; i < count; i++) {
            result += i;
            System.out.println(taskName + i);
        }
        return result;
    }
}
public class Ex13 {
    public static void main(String[] args) {
        Callable<Integer> r1 = new MyTask2("task 1: ", 5);
        Callable<Integer> r2 = new MyTask2("task 2: ", 10);
        try {
            Integer result1 = r1.call();
            Integer result2 = r2.call();
            System.out.println("Result of task 1: " + result1);
            System.out.println("Result of task 2: " + result2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

