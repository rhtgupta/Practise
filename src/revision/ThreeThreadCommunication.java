package revision;

public class ThreeThreadCommunication {
    public static int COUNTER = 1;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new Task(1, lock, 1));
        Thread t2 = new Thread(new Task(2, lock, 2));
        Thread t3 = new Thread(new Task(0, lock, 3));
        t1.start();
        t2.start();
        t3.start();
    }

    public static class Task implements Runnable {
        private int reminder;
        private Object lock;
        int print;

        Task(int reminder, Object lock, int print) {
            this.reminder = reminder;
            this.lock = lock;
            this.print = print;
        }

        @Override
        public void run() {
            System.out.println("-----------------" + Thread.currentThread().getName());
            synchronized (lock) {
                while (true) {
                    if (COUNTER % 3 == reminder) {
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
