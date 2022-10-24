package lec_1_a;

public class NumberC implements Runnable{



    @Override
    public void run()
    {
        System.out.println("Priority : "+Thread.currentThread().getName()+" : "+Thread.currentThread().getPriority());
        for (int i =1; i <=100;i++)
        {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
