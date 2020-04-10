package test.thread;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {
    private static int finalCount = 0;
    private CountDownLatch latch;

    public MyThread(int finalCount, CountDownLatch latch) {
        this.finalCount = finalCount;
        this.latch = latch;
    }

    private static int incrementAndGet() {
        int calcCount = Singleton.getInstance().getCalkCount();
        calcCount++;
        Singleton.getInstance().setCalkCount(calcCount);
        return calcCount;
    }


    @Override
    public void run() {
        try {
            latch.countDown();
            latch.await();
            Singleton instance = Singleton.getInstance();
            while (true) {
                synchronized (instance) {
                    if (finalCount == instance.getCalkCount()) {
                        break;
                    }
                    System.out.println(getName() + " : " + incrementAndGet());
                }
                yield();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
