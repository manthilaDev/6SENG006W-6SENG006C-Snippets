package lec_5_b;

public class MyThread02 implements Runnable{

    public MyThread02(){
        super();
    }
    @Override
    public void run() {
        ThreadGroup Group = new ThreadGroup("Group 2");
        System.out.println("The parent of group 02 "+ Group.getParent().getName());

        for(int i =65;  i<=122; i++)
        {
            System.out.println("Name : "+Thread.currentThread().getName()+
                    " Thread Group Name : "+Thread.currentThread ().getThreadGroup().getName() +" "+(char)i);
        }

    }
}
