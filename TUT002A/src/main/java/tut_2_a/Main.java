package tut_2_a;
public class Main {
    public static void main(String[] args) {

        Resource plate = new Resource("Rice Plate",false);

        Runnable mother = new ServiceProvider(plate,"Rani");
        Runnable son = new Consumer(plate,"Sunil");

        Thread th1 = new Thread(mother,"Rani");
        Thread th2 = new Thread(son,"Sunil");

        th1.start();
        th2.start();
    }
}