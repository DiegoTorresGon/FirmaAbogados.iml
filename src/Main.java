import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();

        try {
            Scanner input = new Scanner(new File("src\\empleados.txt"));

            ArrayList<Employee>[] employee = new ArrayList[6];

            for (int i = 0; i < 6; ++i) employee[i] = new ArrayList<>();

            input.nextLine();

            int e;

            while (input.hasNext()) {
                String name = input.next();
                e = input.nextInt();

                switch (e) {
                    case Job.HARVARDLAWYER -> employee[e].add(new HarvardLawyer(input.nextInt(), input.next(), name));
                    case Job.JANITOR -> employee[e].add(new Janitor(input.nextInt(), input.next(), name));
                    case Job.LAWYER -> employee[e].add(new Lawyer(input.nextInt(), input.next(), name));
                    case Job.LEGALSECRETARY -> employee[e].add(new LegalSecretary(input.nextInt(), input.next(), name));
                    case Job.MARKETER -> employee[e].add(new Marketer(input.nextInt(), input.next(), name));
                    case Job.SECRETARY -> employee[e].add(new Secretary(input.nextInt(), input.next(), name));
                }
            }

            mainWindow.setEmployeeList(employee);

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }
}

