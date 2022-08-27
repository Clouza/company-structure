package net.clouza.company.business;

import net.clouza.company.Employee;
import net.clouza.company.technical.TechnicalEmployee;
import net.clouza.company.technical.TechnicalLead;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public class BusinessLead extends BusinessEmployee implements BusinessLeadInterface {
    private int headCount;
    private double currentBudget = 0;
    private ArrayList<Accountant> reports = new ArrayList<>();

    /**
     * Should create a new BusinessLead that is a Manager. The
     * BusinessLead's base salary should be twice that of an
     * Accountant. They should start with a head count of 10.
     * @param name
     */
    public BusinessLead(String name) {
        super(name);
        this.setBaseSalary(this.getBaseSalary() * 2);
        this.headCount = 10;
    }

    public boolean hasHeadCount() {
        if(reports.size() < this.headCount) {
            return true;
        }
        return false;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if(this.hasHeadCount()) {
            // add to the Business Lead's direct reports
            reports.add(e);
            e.setManager(this);

            e.supportTeam(supportTeam); // store teams to the accountant class
            this.currentBudget += e.getBaseSalary() * 1.1;
            this.setBonusBudget(this.getBaseSalary() + this.currentBudget);
            return true;
        }
        return false;
    }

    public boolean requestBonus(Employee e, double bonus) {
        if(bonus < this.getBonusBudget()) { // is fit in current budget?
            e.setBaseSalary(e.getBaseSalary() + bonus);

            // added bonus to the accountant
            for (int i = 0; i < reports.size(); i++) {
                if(reports.get(i).getEmployeeID() == e.getEmployeeID()) {
                    reports.get(i).setBonusBudget(reports.get(i).getBonusBudget() + bonus);
                }
            }

            // decrease budget
            double rest = this.getBonusBudget() - bonus;
            this.setBonusBudget(rest);
            return true;
        }
        return false;
    }

    public boolean approveBonus(Employee e, double bonus) {
        for (int i = 0; i < reports.size(); i++) {
            boolean match = reports.get(i).getTeamSupported().equals(e.getManager());
            boolean approved = reports.get(i).approveBonus(bonus);

            if(match && approved) { // is fit in accountant budget?
                return true;
            }
        }

        return false;
    }

    public String getTeamStatus() {
        if(reports.isEmpty()) { // has no reports
            return String.format("%s and no direct reports yet", this.employeeStatus());
        } else {
            final String[] Accountants = {""};
            for (int i = 0; i < reports.size(); i++) {
                Accountants[0] += reports.get(i).employeeStatus() + "\n";
            }
            return String.format("%s and is managing: \n%s", this.employeeStatus(), Accountants[0]);
        }
    }
}
