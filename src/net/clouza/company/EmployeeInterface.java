package net.clouza.company;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public interface EmployeeInterface {
    /**
     * Should return the employee's base salary
     * @return double
     */
    public double getBaseSalary();

    /**
     * Should return the employee's name
     * @return String
     */
    public String getName();

    /**
     * Should return the employee's ID.
     *
     * The ID should be issued on behalf of the employee at the
     * time they are constructed. The first employee should have
     * an ID of "1", the second "2" and so on
     * @return int
     */
    public int getEmployeeID();

    /**
     * Should return a reference to the Employee object that
     * represents this employee's manager
     * @return Object
     */
    public Employee getManager();

    /**
     * Should return true if the two employee’s ID are the same,
     * false otherwise
     * @param other
     * @return boolean
     */
    public boolean equals(Employee other);

    /**
     * Should return a String representation of the employee that
     * is a combination of their id followed by their name.
     * Example: "1 Kasey"
     * @return String
     */
    @Override
    public String toString();

    /**
     * Should return a String representation of that Employee's
     * current status. This will be different for every subclass of
     * Employee
     * @return String
     */
    abstract String employeeStatus();
}
