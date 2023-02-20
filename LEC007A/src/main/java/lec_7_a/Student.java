package lec_7_a;

public class Student implements Runnable{
    private String name;
    private ThreadGroup group;
    private Printer printer;

    public Student(String name,ThreadGroup group,Printer printer){
        super();
        this.name = name;
        this.group = group;
        this.printer = printer;
    }
    @Override
    public void run() {
        Document [] documents = new Document[5];
        documents [0]= new Document("DOC001","6SENG006C_CWK",20);
        documents [1]= new Document("DOC002","6COSC023C_CWK01_PP",30);
        documents [2]= new Document("DOC003","6COSC023C_CWK01_PP",75);
        documents [3]= new Document("DOC004","6SEG005C_CWK",30);
        documents [4]= new Document("DOC005","Final_project_draft",150);
        int noOfPages =0;
        for(Document doc: documents){
            printer.printDocument(doc);
            noOfPages += doc.getNumberOfPages();
            try{
                int num = ((int)(Math.random()*100));
                Thread.sleep(num);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" "+"Finished Printing : 5 Documents , "+noOfPages+" pages");

    }
}
