package revision1;

public class FourThreadsCommunication implements Runnable {

    private static int counter = 1;
    private static int noOfTimes = 12;
    static Object lock = new Object();
    private int remainder;

    FourThreadsCommunication(int remainder) {
        this.remainder = remainder;
    }

    public void run() {
        while (counter <= noOfTimes - 3) {
            synchronized (lock) {
                while (counter % 4 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter);
                counter++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new FourThreadsCommunication(1));
        Thread t2 = new Thread(new FourThreadsCommunication(2));
        Thread t3 = new Thread(new FourThreadsCommunication(3));
        Thread t4 = new Thread(new FourThreadsCommunication(0));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
