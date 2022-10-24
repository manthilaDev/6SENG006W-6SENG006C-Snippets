package lec_3_a;

public class MyThread implements  Runnable{
    @Override
    public void run() {
        for (int i =0; i <=10; i++){
            System.out.println(Thread.currentThread().getName()+" : "+ i);
            try{
                Thread.sleep(100); //Moving thread into timed waiting state
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
