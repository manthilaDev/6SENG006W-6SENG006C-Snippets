package lec_7_a;

public class LaserPrinter implements ServicePrinter{

    private String name;
    private int id;
    private int currentPaperLevel;
    private int currentTonerLevel;
    private int completedPrintJobs;
    private boolean paperRefiled = false;
    private boolean tonerReplaced =false;

    public LaserPrinter(String name,int id,int currentPaperLevel,int currentTonerLevel,int completedPrintJobs){
        super();
        this.name= name;
        this.id = id;
        this.currentTonerLevel = currentTonerLevel;
        this.currentPaperLevel = currentPaperLevel;
        this.completedPrintJobs = completedPrintJobs;
    }

    public boolean isPaperRefiled(){
        return paperRefiled;
    }

    public boolean isTonerReplaced(){
        return tonerReplaced;
    }


    @Override
    public synchronized void printDocument(Document document) {
        while(!(document.getNumberOfPages() <= this.currentPaperLevel && document.getNumberOfPages() <= this.currentTonerLevel))
        {
            try{
                wait();

            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

        this.currentPaperLevel -= document.getNumberOfPages();
        this.currentTonerLevel -= document.getNumberOfPages();
        this.completedPrintJobs ++;
        notifyAll();
    }

    @Override
    public synchronized void replaceTonerCartridge() {
        boolean tried = false;
        while(this.currentTonerLevel > (Minimum_Toner_Level-1)){
            if(tried){
                break;
            }
            try{
                wait(5000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            tried = true;
        }
        if(this.currentTonerLevel < Minimum_Toner_Level){
            this.currentTonerLevel = 500;
            this.tonerReplaced = true;
        }
        notifyAll();
    }

    @Override
    public synchronized void refillPaper() {
        boolean tried = false;
        this.paperRefiled =false;
        while(!(this.currentPaperLevel <= Full_Paper_Tray- 50)){
            if(tried){
                break;
            }
            try {
                wait(5000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            tried = true;
        }
        if (this.currentPaperLevel <= (Full_Paper_Tray-50))
        {
            this.currentPaperLevel +=50;
            this.paperRefiled = true;
        }
        notifyAll();

    }

    @Override
    public String toString(){
        return "[PrinterID: "+ this.name+"."+this.id+", Paper Level: "+this.currentPaperLevel+", Toner Level: "+this.currentTonerLevel+", Documents Printed: "+this.completedPrintJobs+" ]";
    }

}
