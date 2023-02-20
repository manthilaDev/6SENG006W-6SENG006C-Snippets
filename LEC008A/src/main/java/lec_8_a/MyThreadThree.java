package lec_8_a;

public class MyThreadThree implements Runnable{
    public MyThreadThree(String name){

    }

    @Override
    public void run() {
        System.out.println("Hello from thread Three");
    }
}
