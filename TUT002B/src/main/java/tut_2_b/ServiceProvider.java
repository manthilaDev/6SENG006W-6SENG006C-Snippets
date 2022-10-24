package tut_2_b;

public class ServiceProvider extends Thread{

    private Resource plate;
    private String name;

    public ServiceProvider(Resource plate,String name){
        super(name);
        this.plate = plate;
        this.name =name;
    }


    @Override
    public void run() {
        for(int i=0;i<=10;i++){
            this.plate.fillResource();
        }
    }
}
