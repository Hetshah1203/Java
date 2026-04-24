abstract class Employee {
    String name;
    String panNo;
    String joiningDate;
    String designation;
    int empId;

    Employee(String name, String panNo, String joiningDate,
             String designation, int empId) throws InvalidEmployeeException {

        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeException("Name cannot be empty");
        }

        if (empId <= 0) {
            throw new InvalidEmployeeException("Invalid Employee ID");
        }

        this.name = name;
        this.panNo = panNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.empId = empId;
    }

    abstract double calcCTC();

    abstract String getEmployeeType();
    abstract double getBaseSalary();
    abstract double getHealthIns();
    abstract double getBonus();
    abstract double getOptions();
}