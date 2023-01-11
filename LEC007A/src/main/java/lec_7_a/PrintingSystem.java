package lec_7_a;

public class PrintingSystem {
    public static void main(String[] args) {
        LaserPrinter printer = new LaserPrinter("iitPrinter",10,500,500,0);
        ThreadGroup studentGroup = new ThreadGroup("Student Thread Group");
        ThreadGroup technicianGroup = new ThreadGroup("Technician Thread Group");

        Runnable student01 = new Student("Nuvin",studentGroup,printer);
        Runnable student02 = new Student("Tharidhi",studentGroup,printer);
        Runnable student03 = new Student("Nabel",studentGroup,printer);
        Runnable student04 = new Student("Sabeeha",studentGroup,printer);

        Thread studentTh01 = new Thread(studentGroup,student01,"Nuvin");
        Thread studentTh02 = new Thread(studentGroup,student02,"Tharidhi");
        Thread studentTh03 = new Thread(studentGroup,student03,"Nabel");
        Thread studentTh04 = new Thread(studentGroup,student04,"Sabeeha");

        Runnable paperTech = new PaperTechnician("PaperTech",technicianGroup,printer);
        Runnable tonerTech = new TonerTechnician("TonerTech",technicianGroup,printer);

        Thread paperTh = new Thread(technicianGroup,paperTech,"Papper Tech");
        Thread tonerTh = new Thread(technicianGroup,tonerTech,"toner Tech");

        studentTh01.start();
        studentTh02.start();
        studentTh03.start();
        studentTh04.start();

        paperTh.start();
        tonerTh.start();

    }
}
