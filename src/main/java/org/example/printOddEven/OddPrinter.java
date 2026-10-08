package org.example.printOddEven;

public class OddPrinter implements Runnable{
    private SharedClass sharedClass;
    public OddPrinter(SharedClass sharedClass){
        this.sharedClass=sharedClass;
    }
    @Override
    public void run(){
       while(true){
           synchronized (sharedClass){
               if(sharedClass.getCounter()%2==0&&sharedClass.getCounter()<=sharedClass.getMAX_VALUE()){
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
