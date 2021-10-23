import java.lang.String;

// Clase para representar empleados en general (manual de 20 páginas).
public class Employee {

    private final int years;
    private final String id;
    private final String name;

    public Employee(int initialYears, String employeeId, String employeeName) {
        years = initialYears;
        id = employeeId;
        name = employeeName;
    }

    public int getHours()
    {
        return 40;		// trabaja 40 horas / semana
    }

    public double getSalary()
    {
        return 40000.0;		// $50,000.00 / año
    }

    public int getVacationDays()
    {
        return 10 + getSeniorityBonus(); // 2 semanas de vacaciones pagadas
    }

    // días de vacaciones por cada año en la compañía
    public int getSeniorityBonus()
    {
        return 2 * years;
    }

    public int getYears()
    {
        return years;
    }

    public String getVacationForm()
    {
        return "amarillo"; 	// usa la forma amarilla
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return id + " " + name;
    }
}
