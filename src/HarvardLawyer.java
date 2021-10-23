public class HarvardLawyer extends Lawyer{

    public HarvardLawyer(String employeeId, String employeeName, int initialYears) {
        super(employeeId, employeeName, initialYears);
    }

    public double getSalary() {
        return super.getSalary() * 1.2;
    }

    public int getVacationDays() {
        return super.getVacationDays() + 3;
    }

    public String getVacationForm() {
        return "pinkpinkpinkpink";
    }
}
