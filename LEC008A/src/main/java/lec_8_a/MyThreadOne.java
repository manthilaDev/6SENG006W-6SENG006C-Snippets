package lec_8_a;

public class MyThreadOne extends Thread{

    public MyThreadOne(String name){
        super(name);

    }


    @Override
    public void run() {
        //Body of thread goes here
        System.out.println("Hello from thread one");

    }
}
