package lec_5_b;

public class Main {
    public static void main(String[] args) {
        // Thread ()
        // Allocates a new Thread Object
        MyThread01 t1 = new MyThread01();
        t1.start();
        // Thread (String name)
        // Allocates a new Thread Object
        MyThread01 t2 = new MyThread01("T2");
        t2.start();
        // Thread (ThreadGroup group, String name)
        // Allocates a new Thread Object
        ThreadGroup group1 = new ThreadGroup("Group 1");
        Thread t3 = new MyThread01(group1,"T3");
        t3.start();
        // Thread (Runnable Target)
        // Allocates a new Thread Object
        Thread t4 = new Thread(new MyThread02());
        t4.start();
        // Thread (Runnable Target,String Name)
        // Allocates a new Thread Object
        Thread t5 = new Thread(new MyThread02(),"T5");
        t5.start();
        // Thread (ThreadGroup group,Runnable target)
        // Allocates a new Thread Object
        Thread t6 = new Thread(group1,new MyThread02());
        t6.start();
        // Thread (ThreadGroup group,Runnable target,String name)
        // Allocates a new Thread Object so that has target as its run object
        // has the specified name as its name
        // and belongs to the thread group referred to by the group
        Thread t7 = new Thread(group1,new MyThread02(),"T7");
        t7.start();
    }


}
