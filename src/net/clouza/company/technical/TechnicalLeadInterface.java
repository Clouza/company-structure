package net.clouza.company.technical;

import net.clouza.company.Employee;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public interface TechnicalLeadInterface {
    /**
     * Should return true if the number of direct reports this
     * manager has is less than their headcount.
     * @return boolean
     */
    public boolean hasHeadCount();

    /**
     * Should accept the reference to a SoftwareEngineer object,
     * and if the TechnicalLead has head count left should add this
     * employee to their list of direct reports. If the employee is
     * successfully added to the TechnicalLead's direct reports
     * true should be returned, false should be returned otherwise
     * @param e
     * @return boolean
     */
    public boolean addReport(SoftwareEngineer e);

    /**
     * Should see if the employee passed in does report to this
     * manager and if their code access is currently set to "true". If
     * both those things are true, true is returned, otherwise false
     * is returned
     * @param e
     * @return boolean
     */
    public boolean approveCheckIn(SoftwareEngineer e);

    /**
     * Should check if the bonus amount requested would be
     * approved by the BusinessLead supporting this
     * TechnicalLead. If it is, that employee should get that bonus
     * and true should be returned. False should be returned
     * otherwise
     * @param e
     * @param bonus
     * @return
     */
    public boolean requestBonus(Employee e, double bonus);

    /**
     * Should return a String that gives insight into this Manager
     * and all their direct reports. It should return a string that is a
     * combination of the TechnicalLead's employee status
     * followed by each of their direct employee's status on
     * subsequent lines. If the TechnicalLead has no reports it
     * should print their employee status followed by the text "
     * and no direct reports yet ". Example: "10 Kasey has 5
     * successful check ins and no direct reports yet". If the
     * TechnicalLead does have reports it might look something
     * like "10 Kasey has 5 successful check ins and is managing: /n
     * 5 Niky has 2 successful check ins"
     * @return String
     */
    public String getTeamStatus();
}
