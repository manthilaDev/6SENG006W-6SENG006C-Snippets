package tut_3_a;

public class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i =0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+" "+ i);
            try{Thread.sleep(100);}catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

    }
}
