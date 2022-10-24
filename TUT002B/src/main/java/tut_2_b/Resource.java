package tut_2_b;

public class Resource {
    private String foodType;
    private boolean isResourceFilled;

    public Resource(String type,boolean status){
        this.isResourceFilled = status;
        this.foodType = type;
    }

    public boolean isResourceFilled(){
        return isResourceFilled;
    }

    public synchronized boolean fillResource(){
        while(this.isResourceFilled == true){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.isResourceFilled = true;
        System.out.println(Thread.currentThread().getName() +" Plate is "+(this.isResourceFilled()? "Filled": "Empty"));
        notifyAll();
        return isResourceFilled;
    }

    public  synchronized boolean emptyResource(){
        while(this.isResourceFilled == false){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.isResourceFilled = false;
        System.out.println(Thread.currentThread().getName() +" Plate is "+ (this.isResourceFilled()? "Filled": "Empty"));
        notifyAll();
        return isResourceFilled;
    }


}
