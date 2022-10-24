package tut_3_b;

public class Consumer implements Runnable{
    private Resource plate;
    private String name;

    public Consumer(Resource plate,String name){
        this.plate = plate;
        this.name = name;
    }
    @Override
    public void run() {
        for(int i=0;i<=10;i++){
            plate.emptyResource();
        }
    }
}
