package lec_3_a;

public class Main {
    public static void main(String[] args){

        /*
        * Inital Thread object is created.
        * And thread is at the New state of Thread Cycle
        * */
        Thread th1 = new Thread(new MyThread(),"Thread 01");
        Thread th2 = new Thread(new MyThread(),"Thread 02");
        /*
        * Initiating the thread into runnable state
        * */
        th1.start();
        try{
            th1.join(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        th2.start();


    }
}