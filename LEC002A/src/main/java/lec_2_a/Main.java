package lec_2_a;

public class Main {
    public static void main(String[] args) {

        BackAccount sharedAccount = new BackAccount("Acc001",0);
        Runnable careerMindedWife = new CareerMindedWife(sharedAccount,"Filthy Rich Wife");
        Runnable houseBasedHusband = new HouseBasedHusband(sharedAccount,"Lazy Bugger");
        Thread cmw = new Thread(careerMindedWife,((CareerMindedWife)careerMindedWife).getName());
        Thread hbh = new Thread(houseBasedHusband,((HouseBasedHusband)houseBasedHusband).getName());
        cmw.start();
        hbh.start();

    }
}