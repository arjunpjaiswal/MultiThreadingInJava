package org.example.printOddEven;

public class SharedClass {
    private int counter=1;
    private int MAX_VALUE;
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }



    public int getMAX_VALUE() {
        return MAX_VALUE;
    }

    public void setMAX_VALUE(int MAX_VALUE) {
        this.MAX_VALUE = MAX_VALUE;
    }


    public SharedClass(int MAX_VALUE){
        this.MAX_VALUE=MAX_VALUE;
    }

    public void print(){
        System.out.printf("%d is printed by %s \n",counter,Thread.currentThread().getName());
        counter++;
    }
}
