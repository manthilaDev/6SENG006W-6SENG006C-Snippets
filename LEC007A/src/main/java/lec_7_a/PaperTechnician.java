package lec_7_a;

public class PaperTechnician implements Runnable{
    private String name;
    private ThreadGroup group;
    private ServicePrinter printer;

    public PaperTechnician(String name,ThreadGroup group,LaserPrinter printer){
        super();
        this.name = name;
        this.group = group;
        this.printer = printer;
    }


    @Override
    public void run() {
        int count =0;
        for(int i =0; i<3;i++){
            printer.refillPaper();
            if(((LaserPrinter)printer).isPaperRefiled()){
                count++;
            }
            int num = ((int) (Math.random()*100));
            try{
                Thread.sleep(num);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("Paper Technician Finished, packs of paper used: "+ count);

    }
}
