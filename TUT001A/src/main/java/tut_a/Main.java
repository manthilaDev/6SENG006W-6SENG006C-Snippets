package tut_a;
public class Main {
    public static void main(String[] args) {

        Thread t1;
        Thread t2;

        t1 = new SimpleThread("FirstThread");
        t2 = new SimpleThread("SecondThread");
        t1.start();
        t2.start();
    }
}