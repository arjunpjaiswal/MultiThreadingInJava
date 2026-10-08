package org.example.Semaphores;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore washroomPermits=new Semaphore(0);
        washroomPermits.release(2);
        System.out.println(washroomPermits.availablePermits());


    }
}
