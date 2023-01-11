package lec_8_a;

public class Main {
    public static void main(String[] args) {
        Thread th1 = new MyThreadOne("Thread 01");
        th1.start();

        new MyThreadTwo("Thread 02");

        Runnable R1 = new MyThreadThree("Thread 03");

        Thread th3 = new Thread(R1,"Thread 03");
        th3.start();



    }
}
