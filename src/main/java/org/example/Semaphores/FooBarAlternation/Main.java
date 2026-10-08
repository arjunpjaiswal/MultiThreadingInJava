package org.example.Semaphores.FooBarAlternation;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore foo=new Semaphore(1);
        Semaphore bar=new Semaphore(1);
        Thread thread1=new Thread(()->{
            for(int i=0;i<5;i++){
                try{
                    foo.acquire();
                    System.out.println("foo "+Thread.currentThread().getName());
                    bar.release();
                }
                catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

            }
        });
        Thread thread2=new Thread(()->{
            for(int i=0;i<5;i++){
                try{
                    bar.acquire();
                    System.out.println("bar "+Thread.currentThread().getName());
                    foo.release();
                }
                catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

            }
        });
        thread1.start();
        thread2.start();
    }
}
