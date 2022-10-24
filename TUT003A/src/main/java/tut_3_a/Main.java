package tut_3_a;

public class Main {
    public static void main(String[] args) {

        Thread th1 = new Thread(new MyThread(),"First Thread ");
        Thread th2 = new Thread(new MyThread(),"Second Thread");
        printThreadDetails(th1);

        th1.start();
        for(int i =0 ; i<=10;i++){
            System.out.println(Thread.currentThread().getName()+ ": "+ i);
            try{
                Thread.sleep(100);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

        try {
            th1.join(500);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        th2.start();
        printThreadDetails(th2);
    }

    public static void printThreadDetails(Thread th){
        System.out.printf("Name : %s Priority : %s Is Alive : %s Is it Demon %s %n",th.getName(),th.getPriority(),th.isAlive(),th.isDaemon());
    }


}