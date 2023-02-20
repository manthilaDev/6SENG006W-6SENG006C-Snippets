package lec_8_a;

public class MyThreadTwo implements Runnable{

    public MyThreadTwo(String name){
        Thread thread = new Thread(this,name);
        thread.run();
    }


    @Override
    public void run() {
        System.out.println("Hello from thread two");
    }
}
