package revision;

public class TwoThreadsCommunication {
    public static int COUNTER = 1;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new Task(lock, 1, 1));
        Thread t2 = new Thread(new Task(lock, 0, 2));
        t1.start();
        t2.start();
    }

    public static class Task implements Runnable {
        private Object lock;
        private int reminder;
        private int print;

        Task(Object lock, int reminder, int print) {
            this.lock = lock;
            this.reminder = reminder;
            this.print = print;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (COUNTER % 2 == reminder) {
                        System.out.println(print);
                        COUNTER++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
