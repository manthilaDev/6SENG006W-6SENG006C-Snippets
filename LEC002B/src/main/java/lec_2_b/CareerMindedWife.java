package lec_2_b;
public class CareerMindedWife extends Thread{
    private BackAccount account;


    public CareerMindedWife(BackAccount account,String name){
        super(name);
        this.account= account;

    }

    @Override
    public void run() {
        double depositAmount = 10000;
        for(int i=0; i<=10;i++){
            this.account.deposit(depositAmount);
        }
    }
}
