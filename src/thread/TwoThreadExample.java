package thread;

public class TwoThreadExample {

    int counter = 1;
    int maxIteration;

    TwoThreadExample(int maxIteration) {
        this.maxIteration = maxIteration;
    }

    public void printOdd() {
        while (counter < maxIteration) {
            synchronized (this) {
                if (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(1);
                counter++;
                notify();
            }
        }
    }

    public void printEven() {
        while (counter < maxIteration) {
            synchronized (this) {
                if (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(2);
                counter++;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        TwoThreadExample obj = new TwoThreadExample(10);

        Thread t1 = new Thread(() -> {
            obj.printOdd();
        });

        Thread t2 = new Thread(() -> {
            obj.printEven();
        });

        t1.start();
        t2.start();
    }

}
