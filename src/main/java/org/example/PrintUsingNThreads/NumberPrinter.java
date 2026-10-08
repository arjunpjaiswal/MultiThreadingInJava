package org.example.PrintUsingNThreads;

public class NumberPrinter implements Runnable {
    private int threadId;
    private int m;
    private SharedClass sharedClass;

    public NumberPrinter(SharedClass sharedClass, int threadId, int m) {
        this.sharedClass = sharedClass;
        this.threadId = threadId;
        this.m = m;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedClass) {
                while((sharedClass.getCounter() - 1) % m!= threadId && sharedClass.getCounter() <= sharedClass.getMAX_VALUE()) {
                    try {
                        sharedClass.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (sharedClass.getCounter() == sharedClass.getMAX_VALUE()) {
                    sharedClass.notifyAll();
                    break;
                }
                sharedClass.print();
                sharedClass.notifyAll();
            }
        }
    }
}
