package test.thread;

public class MyThread extends Thread {
    private int finalCount = 0;
    private static int calcCount = 0;

    public MyThread(int finalCount) {
        this.finalCount = finalCount;
    }

    public static synchronized int incrementAndGet() {
        return calcCount++;
    }

    @Override
    public void run() {
            while (finalCount >= calcCount) {
                System.out.println(getName() + " : " + incrementAndGet());
                yield();
            }
    }
}
