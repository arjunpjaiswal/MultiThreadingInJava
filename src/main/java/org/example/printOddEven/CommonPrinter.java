package org.example.printOddEven;

public class CommonPrinter implements Runnable {

    private SharedClass sharedClass;
private int threadId;
    public CommonPrinter(SharedClass sharedClass,int threadId) {
        this.sharedClass = sharedClass;
        this.threadId=threadId;
    }

    @Override
    public void run(){
        while(true){
            synchronized(sharedClass){
                while((sharedClass.getCounter()-1)%2!=threadId&&sharedClass.getCounter()<=sharedClass.getMAX_VALUE()){
                    try{
                        sharedClass.wait();
                    }
                    catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
                if(sharedClass.getCounter()==sharedClass.getMAX_VALUE()){
                    sharedClass.notifyAll();
                    break;
                }
                sharedClass.print();
                sharedClass.notifyAll();
            }
        }
    }
}