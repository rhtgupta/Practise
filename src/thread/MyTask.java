package thread;

public class MyTask implements Runnable {

    String taskName;

    MyTask(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task Name : " + taskName + "Current Thread : " + Thread.currentThread().getName());
    }
}
