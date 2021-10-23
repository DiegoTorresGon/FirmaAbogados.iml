import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneralWindow extends JFrame {
    private JPanel mainPanel;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTable table4;
    private DefaultTableCellRenderer cellRenderer;

    public GeneralWindow()
    {
        super("Employee GUI");
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 750);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void createUIComponents() throws Exception {

        List<Lawyer> Lawyers = new ArrayList<>();
        List<Secretary> Secretaries = new ArrayList<>();
        List<Marketer> Marketers = new ArrayList<>();
        List<Janitor> Janitors = new ArrayList<>();

        Scanner scan = new Scanner(new File("employees.txt"));

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Scanner lineScan = new Scanner(line);
            String eClass = lineScan.next();
            int id = lineScan.nextInt();
            String name = lineScan.next() + " " + lineScan.next();
            int years = lineScan.nextInt();

            switch (eClass){

                case "Lawyer":
                    Lawyer lawyer = new Lawyer(id, name, years);
                    Lawyers.add(lawyer);
                    break;

                case "HarvardLawyer":
                    HarvardLawyer harvardLawyer = new HarvardLawyer(id, name, years);
                    Lawyers.add(harvardLawyer);
                    break;

                case "Secretary":
                    Secretary secretary = new Secretary(id, name, years);
                    Secretaries.add(secretary);
                    break;

                case "LegalSecretary":
                    LegalSecretary legalSecretary = new LegalSecretary(id, name, years);
                    Secretaries.add(legalSecretary);
                    break;

                case "Marketer":
                    Marketer marketer = new Marketer(id, name, years);
                    Marketers.add(marketer);
                    break;

                case "Janitor":
                    Janitor janitor = new Janitor(id, name, years);
                    Janitors.add(janitor);
                    break;

            }
        }

        String[] columnNames = {"Id", "Nombre", "Años", "Salario", "Hrs / semana", "Vacaciones", "Formulario"};

        Object[][] data1 = new Object [Lawyers.size()][7];
        for (int i = 0; i <Lawyers.size(); i++){
            data1[i][0] = Lawyers.get(i).getId();
            data1[i][1] = Lawyers.get(i).getName();
            data1[i][2] = Lawyers.get(i).getYears();
            data1[i][3] = Lawyers.get(i).getSalary();
            data1[i][4] = Lawyers.get(i).getHours();
            data1[i][5] = Lawyers.get(i).getVacationDays();
            data1[i][6] = Lawyers.get(i).getVacationForm();
        }

        table1 = new JTable(data1, columnNames);
        table1.setEnabled(false);
        table1.getColumnModel().getColumn(0).setPreferredWidth(40);
        table1.getColumnModel().getColumn(1).setPreferredWidth(130);
        table1.getColumnModel().getColumn(2).setPreferredWidth(40);
        table1.getColumnModel().getColumn(4).setPreferredWidth(85);
        table1.getColumnModel().getColumn(6).setPreferredWidth(120);

        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        table1.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        table1.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        table1.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        table1.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        table1.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);

        Object[][] data2 = new Object [Secretaries.size()][7];
        for (int i = 0; i <Secretaries.size(); i++){
            data2[i][0] = Secretaries.get(i).getId();
            data2[i][1] = Secretaries.get(i).getName();
            data2[i][2] = Secretaries.get(i).getYears();
            data2[i][3] = Secretaries.get(i).getSalary();
            data2[i][4] = Secretaries.get(i).getHours();
            data2[i][5] = Secretaries.get(i).getVacationDays();
            data2[i][6] = Secretaries.get(i).getVacationForm();
        }

        table2 = new JTable(data2, columnNames);
        table2.setEnabled(false);
        table2.getColumnModel().getColumn(0).setPreferredWidth(40);
        table2.getColumnModel().getColumn(1).setPreferredWidth(130);
        table2.getColumnModel().getColumn(2).setPreferredWidth(40);
        table2.getColumnModel().getColumn(4).setPreferredWidth(85);
        table2.getColumnModel().getColumn(6).setPreferredWidth(120);

        table2.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        table2.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        table2.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        table2.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        table2.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);

        Object[][] data3 = new Object [Marketers.size()][7];
        for (int i = 0; i <Marketers.size(); i++){
            data3[i][0] = Marketers.get(i).getId();
            data3[i][1] = Marketers.get(i).getName();
            data3[i][2] = Marketers.get(i).getYears();
            data3[i][3] = Marketers.get(i).getSalary();
            data3[i][4] = Marketers.get(i).getHours();
            data3[i][5] = Marketers.get(i).getVacationDays();
            data3[i][6] = Marketers.get(i).getVacationForm();
        }

        table3 = new JTable(data3, columnNames);
        table3.setEnabled(false);
        table3.getColumnModel().getColumn(0).setPreferredWidth(40);
        table3.getColumnModel().getColumn(1).setPreferredWidth(130);
        table3.getColumnModel().getColumn(2).setPreferredWidth(40);
        table3.getColumnModel().getColumn(4).setPreferredWidth(85);
        table3.getColumnModel().getColumn(6).setPreferredWidth(120);

        table3.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        table3.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        table3.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        table3.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        table3.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);

        Object[][] data4 = new Object [Janitors.size()][7];
        for (int i = 0; i <Janitors.size(); i++){
            data4[i][0] = Janitors.get(i).getId();
            data4[i][1] = Janitors.get(i).getName();
            data4[i][2] = Janitors.get(i).getYears();
            data4[i][3] = Janitors.get(i).getSalary();
            data4[i][4] = Janitors.get(i).getHours();
            data4[i][5] = Janitors.get(i).getVacationDays();
            data4[i][6] = Janitors.get(i).getVacationForm();
        }

        table4 = new JTable(data4, columnNames);
        table4.setEnabled(false);
        table4.getColumnModel().getColumn(0).setPreferredWidth(40);
        table4.getColumnModel().getColumn(1).setPreferredWidth(130);
        table4.getColumnModel().getColumn(2).setPreferredWidth(40);
        table4.getColumnModel().getColumn(4).setPreferredWidth(85);
        table4.getColumnModel().getColumn(6).setPreferredWidth(120);

        table4.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        table4.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        table4.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        table4.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        table4.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);

    }
}
