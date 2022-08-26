package revision;

public class FiveThreadCommunication implements Runnable {

    static int counter = 1;
    static Object obj = new Object();
    static int noOfIterations = 15;
    private int remainder;

    FiveThreadCommunication(int remainder) {
        this.remainder = remainder;
    }

    public void run() {
        while (counter <= noOfIterations - 4) {
            synchronized (obj) {
                while (counter % 5 != remainder) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter);
                counter++;
                obj.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        FiveThreadCommunication obj1 = new FiveThreadCommunication(1);
        FiveThreadCommunication obj2 = new FiveThreadCommunication(2);
        FiveThreadCommunication obj3 = new FiveThreadCommunication(3);
        FiveThreadCommunication obj4 = new FiveThreadCommunication(4);
        FiveThreadCommunication obj5 = new FiveThreadCommunication(0);

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        Thread t3 = new Thread(obj3);
        Thread t4 = new Thread(obj4);
        Thread t5 = new Thread(obj5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}
