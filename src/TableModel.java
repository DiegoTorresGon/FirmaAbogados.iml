import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {

    private String[] columnNames = {"Id", "Nombre", "Años", "Salario", "Hrs / semana", "Vacaciones", "Formulario"};
    private ArrayList<Employee> eList;

    public TableModel(ArrayList<Employee> eList) {
        this.eList = eList;
    }

    @Override
    public int getRowCount() {
        return eList.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return eList.get(rowIndex).getId();

            case 1:
                return eList.get(rowIndex).getName();

            case 2:
                return eList.get(rowIndex).getYears();

            case 3:
                return eList.get(rowIndex).getSalary();

            case 4:
                return eList.get(rowIndex).getHours();

            case 5:
                return eList.get(rowIndex).getVacationDays();

            case 6:
                return eList.get(rowIndex).getVacationForm();

        }

        return null;

    }
}
