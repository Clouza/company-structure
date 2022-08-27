package net.clouza.company.technical;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public interface SoftwareEngineerInterface {
    /**
     * Should return whether or not this SoftwareEngineer has access to
     * make changes to the code base
     * @return boolean
     */
    public boolean getCodeAccess();

    /**
     * Should allow an external piece of code to update the
     * SoftwareEngieer's code privileges to either true or false
     * @param access
     */
    public void setCodeAccess(boolean access);

    /**
     * Should return the current count of how many times this
     * SoftwareEngineer has successfully checked in code
     * @return int
     */
    public int getSuccessfulCheckIns();

    /**
     * Should check if this SoftwareEngineer's manager approves of their
     * check in. If the check in is approved their successful checkin count
     * should be increased and the method should return "true". If the
     * manager does not approve the check in the SoftwareEngineer's code
     * access should be changed to false and the method should return
     * "false"
     * @return boolean
     */
    public boolean checkInCode();
}
