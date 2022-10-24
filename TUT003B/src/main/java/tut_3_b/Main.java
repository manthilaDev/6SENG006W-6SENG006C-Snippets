package tut_3_b;

public class Main {
    public static void main(String[] args) {

        Resource plate = new Resource("Rice Plate",false);

        Runnable mother = new ServiceProvider(plate,"Rani");
        Runnable child1 = new Consumer(plate,"Sunil");
        Runnable child2 = new Consumer(plate,"Sumane");
        Runnable child3 = new Consumer(plate,"Jinadasa");

        Thread th1 = new Thread(mother,"Rani");
        Thread th2 = new Thread(child1,"Sunil");
        Thread th3 = new Thread(child2,"Sumane");
        Thread th4 = new Thread(child3,"Jinadasa");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}