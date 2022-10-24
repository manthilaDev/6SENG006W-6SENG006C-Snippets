package lec_2_b;
public class Main {
    public static void main(String[] args) {

        BackAccount sharedAccount = new BackAccount("Acc001",0);
        Thread careerMindedWife = new CareerMindedWife(sharedAccount,"Filthy Rich Wife");
        Thread houseBasedHusband = new HouseBasedHusband(sharedAccount,"Lazy Bugger");
        careerMindedWife.start();
        houseBasedHusband.start();
    }
}