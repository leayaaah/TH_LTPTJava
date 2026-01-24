package baitap.ex1;

class MyTask implements Runnable{
    private String taskName;
    private int count;



    public MyTask(String taskName, int count) {
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


public class Ex1 {
    public static void main(String[] args) {
        Runnable r1 = new MyTask("task 1: ", 5);
        Runnable r2 = new MyTask("task 2: ", 10);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
