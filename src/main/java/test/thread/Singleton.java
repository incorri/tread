package test.thread;

public class Singleton {
    private int calkCount;
    private Singleton(){
        calkCount = 0;
    }
    private static Singleton instance;

    public int getCalkCount() {
        return calkCount;
    }

    public void setCalkCount(int calkCount) {
        this.calkCount = calkCount;
    }

    public synchronized static Singleton getInstance() {
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
