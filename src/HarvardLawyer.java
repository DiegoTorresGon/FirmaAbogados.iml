public class HarvardLawyer extends Lawyer{

    public HarvardLawyer(int initialYears, String employeeId, String employeeName) {
        super(initialYears, employeeId, employeeName);
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
