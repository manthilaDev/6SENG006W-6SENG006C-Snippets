package lec_5_a;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        System.out.println("Name of the Thread 01 "+t1.getName());
        System.out.println("Name of the Group which the Thread 01 Belongs to " +t1.getThreadGroup().getName());
        ThreadGroup group1 = new ThreadGroup("Thread Group 01");
        System.out.println("Name of the Parent of Thread Group 01 "+ group1.getParent().getName());
        Thread t2 = new Thread(group1,"Thread02");
        System.out.println("Thread name of t2 "+t2.getName()+" Thread Group which t2 belongs to"+ t2.getThreadGroup().getName());
    }


}
