package test.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static int finalCount = 0;

    public static void main(String[] args) throws InterruptedException {
        args = new String[]{"100", "4"};

        finalCount = Integer.valueOf(args[0]);
        int threadsCount = Integer.valueOf(args[1]);
        List<Thread> treads = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(threadsCount);
        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new MyThread(finalCount, latch);
            thread.start();
            treads.add(thread);
        }
        for (Thread tread: treads) {
            tread.join();
        }
        System.out.println(Singleton.getInstance().getCalkCount());
    }


}
