package net.clouza.company.business;

import net.clouza.company.Employee;
import net.clouza.company.technical.TechnicalLead;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public interface BusinessLeadInterface {
    /**
     * Should return true if the number of direct reports this
     * manager has is less than their headcount.
     * @return boolean
     */
    public boolean hasHeadCount();

    /**
     * Should accept the reference to an Accountant object, and if
     * the BusinessLead has head count left should add this
     * employee to their list of direct reports. If the employee is
     * successfully added to the BusinessLead's direct reports true
     * should be returned, false should be returned otherwise. Each
     * time a report is added the BusinessLead's bonus budget
     * should be increased by 1.1 times that new employee's base
     * salary. That employee's team they are supporting should be
     * updated to reflect the reference to the TechnicalLead given. If
     * the employee is successfully added true should be returned,
     * false otherwise.
     * @param e
     * @param supportTeam
     * @return boolean
     */
    public boolean addReport(Accountant e, TechnicalLead supportTeam);

    /**
     * Should check if the bonus amount requested would fit in
     * current BusinessLead's budget. If it is, that employee should
     * get that bonus, the BusinessLeader's budget should be
     * deducted and true should be returned. False should be
     * returned otherwise
     * @param e
     * @param bonus
     * @return boolean
     */
    public boolean requestBonus(Employee e, double bonus);

    /**
     * This function should look through the Accountants the
     * BusinessLead manages, and if any of them are supporting a
     * the TechnicalLead that is the manager of the Employee passed
     * in then the Accountant's budget should be consulted to see if
     * the bonus could be afforded. If the team can afford the bonus
     * it should be rewarded and true returned, false otherwise
     * @param e
     * @param bonus
     * @return boolean
     */
    public boolean approveBonus(Employee e, double bonus);
}
