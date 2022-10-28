package lec_4_c;

public class Main {
    public static void main(String [] args){
        System.out.println("Name : " +Thread.currentThread().getName()); //main
        System.out.println("Thread Group Name : " +Thread.currentThread().getThreadGroup().getName()); //main
        ThreadGroup tg1 = new ThreadGroup("TG01");
        System.out.println("Who is the parent of tg1 ? "+ tg1.getParent().getName());
        ThreadGroup tg2 = new ThreadGroup(tg1,"TG02");
        /*
        * who created this thread object ? main thread
        * which is thread group to which main thread belongs to ? main thread group
        * which is thread group to which "t1" thread belongs to ? main thread group
        * */
        Thread t1 = new Thread("T1");
        /*
         * who created this thread object ? main thread
         * which is thread group to which main thread belongs to ? main thread group
         * which is thread group to which "t2" thread belongs to ? TG01
         * */
        Thread t2 = new Thread(tg1,"T2");

        Thread t3 = new Thread(tg2,"T3");

    }

}
