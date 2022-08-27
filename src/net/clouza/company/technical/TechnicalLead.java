package net.clouza.company.technical;

import net.clouza.company.Employee;
import net.clouza.company.business.Accountant;
import net.clouza.company.business.BusinessLead;

import java.util.HashMap;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public class TechnicalLead extends TechnicalEmployee implements TechnicalLeadInterface {
    private HashMap<Integer, SoftwareEngineer> reports = new HashMap<>();
    private int heads;

    /**
     * Should create a new TechnicalLead that is a Manager. The
     * TechnicalLead's base salary should be 1.3 times that of a
     * TechnicalEmployee. TechnicalLeads should have a default
     * head count of 4.
     * @param name
     */
    public TechnicalLead(String name) {
        super(name);
        this.setBaseSalary(this.getBaseSalary() * 1.3);
        this.heads = 4;
    }

    public boolean hasHeadCount() {
        return  reports.size() < this.heads;
    }

    public boolean addReport(SoftwareEngineer e) {
        if(this.hasHeadCount()) {
            // add to the Technical Lead's direct reports
            this.reports.put(e.getEmployeeID(), e);
            e.setManager(this);
            return true;
        }
        return false;
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        // passed to manager & code access granted
        if(reports.containsKey(e.getEmployeeID()) && e.getCodeAccess()) {
            return true;
        }
        return false;
    }

    public boolean requestBonus(Employee e, double bonus) {
        BusinessLead manager = (BusinessLead) this.getManager();
        if(manager.approveBonus(e, bonus)) {
            e.setBaseSalary(e.getBaseSalary() + bonus); // employee get the bonus
            return true;
        }
        return false;
    }

    public String getTeamStatus() {
        if(reports.isEmpty()) { // has no reports
            return String.format("%s and no direct reports yet", this.employeeStatus());
        } else {
            final String[] SEs = {""};
            reports.forEach((key, value) -> {
                SEs[0] += value.employeeStatus() + "\n";
                this.checkIns += value.getSuccessfulCheckIns();
            });
            return String.format("%s and is managing: \n%s", this.employeeStatus(), SEs[0]);
        }
    }

    public HashMap<Integer, SoftwareEngineer> getReports() {
        return this.reports;
    }

}
