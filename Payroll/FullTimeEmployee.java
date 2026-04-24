class FullTimeEmployee extends Employee {

    double baseSalary;
    double healthIns;
    double perfBonus;
    double options;
    String role;

    FullTimeEmployee(String name, String panNo, String joiningDate,
                     String designation, int empId,
                     double baseSalary, double healthIns,
                     double perfBonus, double options, String role)
            throws InvalidEmployeeException {

        super(name, panNo, joiningDate, designation, empId);

        if (baseSalary < 0 || healthIns < 0 || perfBonus < 0 || options < 0) {
            throw new IllegalArgumentException("Salary components cannot be negative");
        }

        this.baseSalary = baseSalary;
        this.healthIns = healthIns;
        this.perfBonus = perfBonus;
        this.options = options;
        this.role = role;
    }

    @Override
    double calcCTC() {
        if (role.equals("SWE")) {
            return baseSalary + perfBonus;
        } else if (role.equals("HR")) {
            double hiringCommission = 20000;
            return baseSalary + hiringCommission;
        }
        return baseSalary;
    }

    @Override
    String getEmployeeType() {
        return "FT";
    }

    @Override
    double getBaseSalary() { return baseSalary; }

    @Override
    double getHealthIns() { return healthIns; }

    @Override
    double getBonus() { return perfBonus; }

    @Override
    double getOptions() { return options; }
}