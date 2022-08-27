package net.clouza.company.technical;

import net.clouza.company.Employee;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public abstract class TechnicalEmployee extends Employee implements TechnicalEmployeeInterface {
    protected int checkIns;

    /**
     * Has a default base salary of 75000
     * @param name
     */
    public TechnicalEmployee(String name) {
        super(name, 75000);
    }

    @Override
    public String employeeStatus() {
        return String.format("%s has %d successful check ins", super.toString(), this.checkIns);
    }
}
