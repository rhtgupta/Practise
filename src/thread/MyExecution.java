package thread;

public class MyExecution implements Runnable{

    public void executeMyMethod(){
        if(MyThreadPool.initialCapacity < MyThreadPool.capacity){
            MyThreadPool.initialCapacity++;
            Thread thread = new Thread(new MyExecution());
            thread.start();
        }
    }

    public void run(){
        while(true){
            if(MyThreadPool.blockingQueue.size() != 0){
                MyThreadPool.blockingQueue.poll().run();
            }
        }
    }
}
