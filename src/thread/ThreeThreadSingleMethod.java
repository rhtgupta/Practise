package thread;

public class ThreeThreadSingleMethod implements Runnable {

    static int counter = 1;
    int maxInteration;
    int remainder;
    static Object lock = new Object();

    ThreeThreadSingleMethod(int maxInteration, int remainder) {
        this.maxInteration = maxInteration;
        this.remainder = remainder;
    }

    public void run() {
        while (counter < maxInteration) {
            synchronized (lock) {
                while (counter % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread Name : " + Thread.currentThread().getName() + " Value : " + counter);
                counter++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ThreeThreadSingleMethod printOne = new ThreeThreadSingleMethod(8, 1);
        ThreeThreadSingleMethod printTwo = new ThreeThreadSingleMethod(8, 2);
        ThreeThreadSingleMethod printThree = new ThreeThreadSingleMethod(8, 0);

        Thread t1 = new Thread(printOne);
        Thread t2 = new Thread(printTwo);
        Thread t3 = new Thread(printThree);

        t1.start();
        t2.start();
        t3.start();
    }
}
