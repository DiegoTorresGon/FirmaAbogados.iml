public class Janitor extends Employee{

    public Janitor(int initialYears, String employeeId, String employeeName) {
        super(initialYears, employeeId, employeeName);
    }

    public int getHours() { return super.getHours() * 2; }

    public double getSalary() {
        return super.getSalary() - 10000;
    }

    public int getVacationDays() {
        return super.getVacationDays() / 2; // La mitad que los empleados normales.
    }

    public String clean() {
        return " Workin' for the man ";
    }

}
