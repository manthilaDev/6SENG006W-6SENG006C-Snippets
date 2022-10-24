package lec_1_a;
public class App{
    public static void main(String [] args){
        System.out.println(Thread.currentThread().getName()+
                " : Priority " +
                Thread.currentThread().getPriority());
        Runnable r1 = new NumberC();
        Runnable r2 = new Alphabet();
        Thread t1 = new Thread(r1,"Number Thread");
        Thread t2 = new Thread(r2,"Alphabet Thread");
        Thread t3 = new Thread(r1);
        t1.start();
        t2.start();
        t3.start();;
    }
}