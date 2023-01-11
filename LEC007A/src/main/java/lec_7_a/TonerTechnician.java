package lec_7_a;

public class TonerTechnician implements Runnable{
    private String name;
    private ThreadGroup group;
    private ServicePrinter printer;

    public TonerTechnician(String name,ThreadGroup group,LaserPrinter printer){
        super();
        this.name = name;
        this.group = group;
        this.printer = printer;
    }


    @Override
    public void run() {
        int count =0;
        for(int i =0; i<3;i++){
            printer.replaceTonerCartridge();
            if(((LaserPrinter)printer).isTonerReplaced()){
                count++;
            }
            int num = ((int) (Math.random()*100));
            try{
                Thread.sleep(num);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("Toner Technician Finished, Cartridge replaced : "+ count);

    }
}
