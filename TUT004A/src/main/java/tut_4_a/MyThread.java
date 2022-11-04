package tut_4_a;

import java.sql.SQLOutput;

public class MyThread extends Thread{

    public MyThread(){
        super();
    }

    public MyThread(String name){
        super(name);
    }

    public MyThread(ThreadGroup group,String name){
        super(group,name);
    }


    @Override
    public void run(){
        for (int i = 0; i <=100 ; i++) {
            System.out.println("Thread Group Name : "+ Thread.currentThread().getThreadGroup().getName()+" "+
                    " Thread Name : "+Thread.currentThread().getName());

        }

    }

}
