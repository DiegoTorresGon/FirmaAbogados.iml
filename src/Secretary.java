public class Secretary extends Employee {

    public Secretary(int initialYears, String employeeId, String employeeName) {
        super(initialYears, employeeId, employeeName);
    }

    // Secretarios no obtienen bono por sus años de servicio.
    public int getSeniorityBonus() {
        return 0;
    }

    public String takeDictation(String text) {
        return "Tomando dictado del texto: " + text;
    }
}
