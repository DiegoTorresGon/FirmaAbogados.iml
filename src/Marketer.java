// Clase para representar especialistas en marketing
public class Marketer extends Employee {

    public Marketer(int employeeId, String employeeName, int initialYears) {
        super(employeeId, employeeName, initialYears);
    }

    public String advertise() {
        return "¡Actúe ahora mientras duren las existencias!";
    }

    public double getSalary()
    {
        double base = super.getSalary();
        return base + 10000.0;		// $10,000.00 / año además del sueldo base
    }
}
