package thread;

public class MyExecutors {
    static MyExecutorService myFixedThreadPool(int capacity) {
        return new MyThreadPool(capacity);
    }

}
