package org.example.printOddEven;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[]args) {
SharedClass sharedClass=new SharedClass(20);
Thread thread1=new Thread(new CommonPrinter(sharedClass,0),"OddPrinter");
Thread thread2=new Thread(new CommonPrinter(sharedClass,1),"EvenPrinter");
thread1.start();
thread2.start();
        }
    }
