package test.thread;


public class Main {
    private static int finalCount = 0;

    public static void main(String[] args) throws InterruptedException {
        args = new String[]{"100", "4"};

        finalCount = Integer.valueOf(args[0]);
        int threadsCount = Integer.valueOf(args[1]);
        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new MyThread(finalCount);
            thread.start();
        }
    }


}
