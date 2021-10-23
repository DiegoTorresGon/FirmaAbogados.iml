// Clase para representar abogados
public class Lawyer extends Employee {

    public Lawyer(String employeeId, String employeeName, int initialYears) {
        super(employeeId, employeeName, initialYears);
    }

    public double getSalary() {
        return super.getSalary() + 5000 * getYears();
    }

    // sobrepone getVacationForm de la clase Employee
    public String getVacationForm() {
        return "rosa";
    }

    // sobrepone getVacationDays de la clase Employee
    public int getVacationDays() {
        return super.getVacationDays() + 5; // 1 semana de vacaciones extra
    }

    public String sue() {
        return "¡Te veré en la corte!";
    }
}
