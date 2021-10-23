public class Secretary extends Employee {

    public Secretary(int employeeId, String employeeName, int initialYears) {
        super(employeeId, employeeName, initialYears);
    }

    // Secretarios no obtienen bono por sus años de servicio.
    public int getSeniorityBonus() {
        return 0;
    }

    public String takeDictation(String text) {
        return "Tomando dictado del texto: " + text;
    }
}
