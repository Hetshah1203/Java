class Manager extends FullTimeEmployee {

    double TA;
    double eduAllowance;

    Manager(String name, String panNo, String joiningDate,
            String designation, int empId,
            double baseSalary, double healthIns,
            double perfBonus, double options,
            double TA, double eduAllowance)
            throws InvalidEmployeeException {

        super(name, panNo, joiningDate, designation, empId,
              baseSalary, healthIns, perfBonus, options, "Manager");

        if (TA < 0 || eduAllowance < 0) {
            throw new IllegalArgumentException("Allowances cannot be negative");
        }

        this.TA = TA;
        this.eduAllowance = eduAllowance;
    }

    @Override
    double calcCTC() {
        return baseSalary + perfBonus + TA + eduAllowance;
    }

    @Override
    String getEmployeeType() {
        return "MGR";
    }
}