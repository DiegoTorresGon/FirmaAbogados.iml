public class HarvardLawyer extends Lawyer{

    public HarvardLawyer(int employeeId, String employeeName, int initialYears) {
        super(employeeId, employeeName, initialYears);
    }

    public double getSalary() {
        return super.getSalary() * 1.2;
    }

    public int getVacationDays() {
        return super.getVacationDays() + 3;
    }

    public String getVacationForm() {

        int rep = 4;

        String repeatVacationForm = "";

        for (int i = 1; i <= rep; i++) {
            repeatVacationForm += super.getVacationForm();
        }

        return repeatVacationForm;

    }

}
