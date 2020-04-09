package test.thread;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {
    private int finalCount = 0;
    private CountDownLatch latch;

    public MyThread(int finalCount, CountDownLatch latch) {
        this.finalCount = finalCount;
        this.latch = latch;
    }

    private static synchronized int incrementAndGet() {
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
            while (finalCount > Singleton.getInstance().getCalkCount()) {
                System.out.println(getName() + " : " + incrementAndGet());
                yield();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
