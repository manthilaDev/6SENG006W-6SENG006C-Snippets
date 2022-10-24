package lec_1_a;

public class Alphabet implements Runnable {
    @Override
    public void run()
    {
        System.out.println("Priority : "+Thread.currentThread().getName()+" : "+Thread.currentThread().getPriority());
        for(int i =65;  i<=95; i++)
        {
            System.out.println(Thread.currentThread().getName()+ " : "+ (char)i);
        }

        for (int i =97; i<=122;i++)
        {
            System.out.println(Thread.currentThread().getName()+ " : "+ (char)i);
        }
    }
}
