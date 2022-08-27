package net.clouza.company;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public abstract class Employee implements EmployeeInterface {
    protected double baseSalary;
    private String name;
    private int employeeID;
    private static int id = 1;
    private Employee manager;

    /**
     * Construct Employee with two parameters name and base
     * salary
     * @param name
     * @param baseSalary
     */
    public Employee(String name, double baseSalary) {
        this.baseSalary = baseSalary;
        this.name = name;
        this.employeeID = id;
        id++;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }
    public void setBaseSalary(double baseSalary){ this.baseSalary = baseSalary; }

    public String getName() {
        return this.name;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public Employee getManager() {return this.manager;}
    public void setManager(Employee manager) {this.manager = manager;}

    public boolean equals(Employee other) {
        return this.employeeID == other.getEmployeeID();
    }

    @Override
    public String toString() {
        return String.format("%d %s", this.getEmployeeID(), this.getName());
    }

    abstract public String employeeStatus();
}
