// Clase para representar secretarios legales
public class LegalSecretary extends Secretary {

    public LegalSecretary(int employeeId, String employeeName, int initialYears) {
        super(employeeId, employeeName, initialYears);
    }

    public String fileLegalBriefs() {
        return "¡Podría archivar todo el día!";
    }

    public double getSalary() {
        double base = super.getSalary();
        return base + 5000.0; // 5,000.00 / año además del sueldo base
    }

}
