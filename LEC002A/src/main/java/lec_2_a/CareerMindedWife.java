package lec_2_a;

public class CareerMindedWife implements Runnable{
    private BackAccount account;
    private String name;

    public CareerMindedWife(BackAccount account,String name){
        super();
        this.account= account;
        this.name= name;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public void run() {
        double depositAmount = 10000;
        for(int i=0; i<=10;i++){
            //System.out.println(this.name+" Balance after the deposit is : "+this.account.deposit(depositAmount));
            this.account.deposit(depositAmount);
//            try{
//            Thread.sleep(100);
//        }catch (InterruptedException e){
//                e.printStackTrace();
//            }
        }
    }
}
