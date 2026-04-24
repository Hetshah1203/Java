class ContractEmployee extends Employee {

    int noOfHrs;
    double hourlyRate;

    ContractEmployee(String name, String panNo, String joiningDate,
                     String designation, int empId,
                     int noOfHrs, double hourlyRate)
            throws InvalidEmployeeException {

        super(name, panNo, joiningDate, designation, empId);

        if (noOfHrs < 0 || hourlyRate < 0) {
            throw new IllegalArgumentException("Hours or rate cannot be negative");
        }

        this.noOfHrs = noOfHrs;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calcCTC() {
        return noOfHrs * hourlyRate;
    }

    @Override
    String getEmployeeType() { return "CT"; }

    @Override
    double getBaseSalary() { return 0; }

    @Override
    double getHealthIns() { return 0; }

    @Override
    double getBonus() { return 0; }

    @Override
    double getOptions() { return 0; }
}