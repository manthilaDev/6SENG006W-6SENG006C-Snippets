package tut_4_a;

public class Main {
    public static void main(String[] args) {
        ThreadGroup [] tGroupArr = new ThreadGroup[6];
        Thread [] tArr = new Thread[7];

        tGroupArr[0] = Thread.currentThread().getThreadGroup();

        tGroupArr[1] = new ThreadGroup("ThreadGroup A");
        tGroupArr[2] = new ThreadGroup("ThreadGroup B");
        tGroupArr[3] = new ThreadGroup("ThreadGroup C");

        tGroupArr[4] = new ThreadGroup("ThreadGroup B1");
        tGroupArr[5] = new ThreadGroup("ThreadGroup B2");

        tArr[0] =new MyThread(tGroupArr[0],"Thread 01");
        tArr[1] =new MyThread(tGroupArr[1],"Thread 02");
        tArr[2] =new MyThread(tGroupArr[1],"Thread 03");
        tArr[3] =new MyThread(tGroupArr[3],"Thread 04");
        tArr[4] =new MyThread(tGroupArr[4],"Thread 05");
        tArr[5] =new MyThread(tGroupArr[4],"Thread 06");
        tArr[6] =new MyThread(tGroupArr[5],"Thread 07");

        for (int i=0; i < tArr.length;i++){
            tArr[i].start();
        }

        int active = tGroupArr[0].activeCount();
        Thread[] threadsArrTwo = new Thread[active*2];
        tGroupArr[0].enumerate(threadsArrTwo);

        System.out.println("Using enumerate with thread array as parameter");
        for(int i=0; i < threadsArrTwo.length;i++){
            if(threadsArrTwo[i] != null){
                System.out.println(threadsArrTwo[i].getName());
            }
        }

        active = tGroupArr[0].activeCount();
        Thread[] threadsArrThree = new Thread[active*2];
        tGroupArr[0].enumerate(threadsArrThree,true);

        for(int i=0; i < threadsArrThree.length;i++){
            if(threadsArrThree[i] != null){
                System.out.println(threadsArrThree[i].getName());
            }
        }

        int activeGroupCount = tGroupArr[0].activeGroupCount();
        ThreadGroup[] activeThreadGroups = new ThreadGroup [activeGroupCount*2];
        tGroupArr[0].enumerate(activeThreadGroups);

        System.out.println("Using enumerate with thread group array");
        for (int i=0; i< activeThreadGroups.length;i++){
            if(activeThreadGroups[i] != null){
                System.out.println(activeThreadGroups[i].getName());
            }
        }

        activeGroupCount = tGroupArr[0].activeGroupCount();
        ThreadGroup[] activeThreadGroupsTwo = new ThreadGroup [activeGroupCount*2];
        tGroupArr[0].enumerate(activeThreadGroups,false); // sets recursive to false
        // so only the childes of the main thread group wil return

        System.out.println("Using enumerate with thread group array");
        for (int i=0; i< activeThreadGroups.length;i++){
            if(activeThreadGroups[i] != null){
                System.out.println(activeThreadGroups[i].getName());
            }
        }

    }
}
