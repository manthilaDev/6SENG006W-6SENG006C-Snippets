package lec_5_b;

public class MyThread01 extends Thread{
    public MyThread01(){
        super();
    }

    public MyThread01(String name){
        super(name);

    }
    public MyThread01(ThreadGroup groupName,String name){
        super(groupName,name);

    }
    @Override
    public void run(){
        for(int i=0;i<=100;i++){
            System.out.println("Name : "+ Thread.currentThread().getName()+
                    " Thread Group Name : "+Thread.currentThread().getThreadGroup().getName()+" : "+ i);
        }
    }

}
