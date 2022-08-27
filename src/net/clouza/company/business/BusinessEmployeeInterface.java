package net.clouza.company.business;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public interface BusinessEmployeeInterface {
    /**
     * Should establish a running tally of the remaining bonusBudget
     * for the team this employee supports. How that budget is
     * determined will depend on which type of Business Employee
     * @return double
     */
    public double getBonusBudget();

    /**
     * Should return a String representation of this BusinessEmployee
     * that includes their ID, name and the size of their currently
     * managed budget. Example: "1 Kasey with a budget of 22500.0"
     * @return String
     */
    public String employeeStatus();
}
