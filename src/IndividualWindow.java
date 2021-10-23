import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IndividualWindow extends JFrame {
    private JComboBox<String> cbEmployeeType;
    private JScrollPane tfEmployeeList;
    private JScrollPane tfEmployeeInfo;
    private JPanel pTitle;
    private JList<Employee> liEmployeeList;
    private JList<String> liEmployeeData;
    private JLabel laTitle;
    private JPanel pMain;
    private JScrollPane tfEmployeeActions;
    private JTextArea taEmployeeActions;
    private ArrayList<Employee>[] employeeList;

    public final int WIDTH = 900, HEIGHT = 600;

    private final String SUE = "Sue!", CLEAN = "Clean!", FILE = "File Legal Briefs!",
            DICTATION = "Take dictation!", ADVERTISE = "Advertise!";

    public IndividualWindow(){

        setVisible(true);
        setLocation(200,40);
        setSize(WIDTH,HEIGHT);
        setContentPane(pMain);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Adding types of Employee to cbEmployeeType
        cbEmployeeType.addItem("Harvard Lawyer");
        cbEmployeeType.addItem("Janitor");
        cbEmployeeType.addItem("Lawyer");
        cbEmployeeType.addItem("Legal Secretary");
        cbEmployeeType.addItem("Marketer");
        cbEmployeeType.addItem("Secretary");

        //Setting ListModels for JLists
        liEmployeeList.setModel(new DefaultListModel<>());
        liEmployeeData.setModel(new DefaultListModel<>());

        //Reading list of employees
        try {

            Scanner input = new Scanner(new File("src\\employees.txt"));

            input.nextLine();


            employeeList = new ArrayList[6];



            for (int i = 0; i < 6; ++i) employeeList[i] = new ArrayList<>();

            while (input.hasNextLine()) {
                String line = input.nextLine();
                Scanner lineScan = new Scanner(line);

                int e = lineScan.nextInt();
                int id = lineScan.nextInt();
                String name = lineScan.next() + " " + lineScan.next();
                int years = lineScan.nextInt();

                switch (e) {
                    case Job.HARVARDLAWYER -> employeeList[e].add(new HarvardLawyer(id, name, years));
                    case Job.JANITOR -> employeeList[e].add(new Janitor(id, name, years));
                    case Job.LAWYER -> employeeList[e].add(new Lawyer(id, name, years));
                    case Job.LEGALSECRETARY -> employeeList[e].add(new LegalSecretary(id, name, years));
                    case Job.MARKETER -> employeeList[e].add(new Marketer(id, name, years));
                    case Job.SECRETARY -> employeeList[e].add(new Secretary(id, name, years));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }

        liEmployeeList.setListData(employeeList[0].toArray(new Employee[0]));

        //Listener for cbEmployeeType
        cbEmployeeType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedType = cbEmployeeType.getSelectedIndex();
                liEmployeeList.setListData(
                       employeeList[selectedType].toArray(new Employee[0]));

                //String[] emptyList = new String[1];
                //emptyList[0] = " ";
                //liEmployeeData.setListData(emptyList);
            }
        });

        //Listener for LiEmployeeList
        liEmployeeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                Employee selectedEmployee = getSelectedEmployee();
                if(selectedEmployee == null) return;

                DefaultListModel<String> listModel = (DefaultListModel<String>) liEmployeeData.getModel();

                listModel.clear();

                listModel.addElement("Name: " + selectedEmployee.getName());
                listModel.addElement("ID: " + selectedEmployee.getId());
                listModel.addElement("Weekly work hours: " + selectedEmployee.getHours());
                listModel.addElement("Worked years: " + selectedEmployee.getYears());
                listModel.addElement("Salary: " + selectedEmployee.getSalary());
                listModel.addElement("Vacation days: " + selectedEmployee.getVacationDays());
                listModel.addElement("Vacation form: " + selectedEmployee.getVacationForm());

                listModel.addElement(" ");

                //Adding specific methods for type of Employee
                switch(cbEmployeeType.getSelectedIndex()) {
                    case Job.HARVARDLAWYER:
                    case Job.LAWYER:
                        listModel.addElement(SUE);
                        break;
                    case Job.JANITOR:
                        listModel.addElement(CLEAN);
                        break;
                    case Job.LEGALSECRETARY:
                        listModel.addElement(FILE);
                    case Job.SECRETARY:
                        listModel.addElement(DICTATION);
                        break;
                    case Job.MARKETER:
                        listModel.addElement(ADVERTISE);
                        break;
                }

            }
        });

        //Adding EmployeeActions
        liEmployeeData.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(liEmployeeData.getSelectedIndex() < 8) return;

                Employee selectedEmployee = getSelectedEmployee();
                if (selectedEmployee == null) return;

                taEmployeeActions.append(selectedEmployee.getName() + ": ");

                switch(liEmployeeData.getSelectedValue()) {
                    case SUE -> taEmployeeActions.append(((Lawyer)selectedEmployee).sue());
                    case CLEAN -> taEmployeeActions.append(((Janitor)selectedEmployee).clean());
                    case FILE -> taEmployeeActions.append(((LegalSecretary)selectedEmployee).fileLegalBriefs());
                    case DICTATION -> taEmployeeActions.append(
                            ((Secretary)selectedEmployee).takeDictation("Soy muy buena secretaria."));
                    case ADVERTISE -> taEmployeeActions.append(((Marketer)selectedEmployee).advertise());
                }

                taEmployeeActions.append("\n");

                liEmployeeData.clearSelection();
            }
        });
    }

    //sets Array of Employees.
    public void setEmployeeList(ArrayList<Employee>[] list) {
        employeeList = list;

        liEmployeeList.setListData(
                employeeList[0].toArray(new Employee[0]));

    }

    //Return current selected Employee (May return null)
    private Employee getSelectedEmployee() {
        if (liEmployeeList.getSelectedIndex() < employeeList[cbEmployeeType.getSelectedIndex()].size() &&
                liEmployeeList.getSelectedIndex() > -1)
            return employeeList[cbEmployeeType.getSelectedIndex()].get(liEmployeeList.getSelectedIndex());
        else return null;
    }

}
