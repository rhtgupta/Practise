package thread_revision;

import revision.FiveThreadCommunication;

public class FiveThreadsCommunicationRevision implements Runnable {

    private static int counter = 1;
    private int remainder;
    private static Object lock = new Object();
    private static int noOfTimes = 15;

    public FiveThreadsCommunicationRevision(int remainder) {
        this.remainder = remainder;
    }

    public void run() {
        while (counter <= noOfTimes - 4) {
            synchronized (lock) {
                try {
                    while (counter % 5 != remainder) {
                        lock.wait();
                    }
                    Thread.sleep(3000);
                    System.out.println(counter);
                    counter++;
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new FiveThreadsCommunicationRevision(1));
        Thread t2 = new Thread(new FiveThreadsCommunicationRevision(2));
        Thread t3 = new Thread(new FiveThreadsCommunicationRevision(3));
        Thread t4 = new Thread(new FiveThreadsCommunicationRevision(4));
        Thread t5 = new Thread(new FiveThreadsCommunicationRevision(0));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
