package net.clouza.company.business;

import net.clouza.company.technical.TechnicalLead;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public class Accountant extends BusinessEmployee implements AccountantInterface {
    private TechnicalLead teamSupported;
    private double totalBudget = 0;

    /**
     * Should start with a bonus budget of 0 and no team they are
     * officially supporting
     * @param name
     */
    public Accountant(String name) {
        super(name);
    }

    public TechnicalLead getTeamSupported() {
        return this.teamSupported;
    }

    public void supportTeam(TechnicalLead lead) {
        this.teamSupported = lead;
        final double[] currentBudget = {0};
        lead.getReports().forEach((key, value) -> {
            currentBudget[0] += value.getBaseSalary();
        });
        this.totalBudget += currentBudget[0] * 1.1;
        this.setBonusBudget(this.totalBudget);
    }

    public boolean approveBonus(double bonus) {
        if(bonus < this.getBonusBudget() || teamSupported == null) {
            this.setBonusBudget(this.getBonusBudget() - bonus);
            return true;
        }
        return false;
    }

    @Override
    public String employeeStatus() {
        return String.format("%s is supporting %s", super.employeeStatus(), teamSupported.getName());
    }
}
