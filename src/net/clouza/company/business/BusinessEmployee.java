package net.clouza.company.business;

import net.clouza.company.Employee;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public abstract class BusinessEmployee extends Employee implements BusinessEmployeeInterface{
    private NumberFormat NF = new DecimalFormat("#0.00");
    private double bonusBudget = 0;

    /**
     * Has a default salary of 50000
     * @param name
     */
    public BusinessEmployee(String name) {
        super(name, 50000);
    }

    public double getBonusBudget() {
        return this.bonusBudget;
    }

    public void setBonusBudget(double bonus) {
        this.bonusBudget = bonus;
    }

    @Override
    public String employeeStatus() {
        return String.format("%d %s with a budget of %s", this.getEmployeeID(), this.getName(), NF.format(this.getBonusBudget()));
    }
}
