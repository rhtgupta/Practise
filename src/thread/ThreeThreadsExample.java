package thread;

public class ThreeThreadsExample {

    int counter = 1;
    int maxIteration;

    ThreeThreadsExample(int maxIteration) {
        this.maxIteration = maxIteration;
    }

    public void printOne() {
        while (counter < maxIteration) {
            synchronized (this) {
                while (counter % 3 != 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(1);
                counter++;
                notifyAll();
            }
        }
    }

    public void printTwo() {
        while (counter < maxIteration) {
            synchronized (this) {
                while (counter % 3 != 2) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(2);
                counter++;
                notifyAll();
            }
        }
    }

    public void printThree() {
        while (counter < maxIteration) {
            synchronized (this) {
                while (counter % 3 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(3);
                counter++;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ThreeThreadsExample obj = new ThreeThreadsExample(8);

        Thread t1 = new Thread(() -> {
            obj.printOne();
        });

        Thread t2 = new Thread(() -> {
            obj.printTwo();
        });

        Thread t3 = new Thread(() -> {
            obj.printThree();
        });

        t1.start();
        t2.start();
        t3.start();

    }

}
