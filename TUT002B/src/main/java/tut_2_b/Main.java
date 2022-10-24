package tut_2_b;

public class Main {
    public static void main(String[] args) {

        Resource plate = new Resource("Rice Plate",false);
        Thread mother = new ServiceProvider(plate,"Rani");
        Thread son = new Consumer(plate,"Sunil");
        mother.start();
        son.start();
    }
}