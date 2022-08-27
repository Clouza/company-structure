package net.clouza.company.business;

import net.clouza.company.technical.TechnicalLead;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public interface AccountantInterface {
    /**
     * Should return a reference to the TechnicalLead that this Accountant
     * is currently supporting. If they have not been assigned a
     * TechnicalLead null should be returned
     * @return TechnicalLead Class
     */
    public TechnicalLead getTeamSupported();

    /**
     * Should allow a reference to a TechnicalLead to be passed and
     * saved. Once this happens the Accountant's bonus budget should be
     * updated to be the total of each SoftwareEngineer's base salary that
     * reports to that TechnicalLead plus 10%. For example, if the
     * TechnicalLead supports 2 SoftwareEngineers, each with a salary of
     * 75000, the Accountant's budget should be 150000 + 15000 for a
     * total of 165000
     * @param lead
     */
    public void supportTeam(TechnicalLead lead);

    /**
     * Should take in a suggested bonus amount and check if there is still
     * enough room in the budget. If the bonus is greater than the
     * remaining budget, false should be returned, otherwise true. If the
     * accountant is not supporting any team false should be returned.
     * @param bonus
     * @return boolean
     */
    public boolean approveBonus(double bonus);

    /**
     * Should return a String representation of this Accountant that
     * includes their ID, name, the size of their currently managed budget
     * and the name of the TechnicalLead they are currently supporting.
     * Example: "1 Kasey with a budget of 22500.0 is supporting Satya
     * Nadella"
     * @return String
     */
    public String employeeStatus();
}
