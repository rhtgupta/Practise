package thread;

public class MyThreadPoolMain {

    public static void main(String[] args) {
        MyExecutorService service = MyExecutors.myFixedThreadPool(4);
        for (int i = 0; i < 30; i++) {
            service.execute(new MyTask("Task" + i));
        }
    }
}
