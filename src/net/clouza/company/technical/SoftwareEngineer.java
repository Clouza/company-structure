package net.clouza.company.technical;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public class SoftwareEngineer extends TechnicalEmployee implements SoftwareEngineerInterface {
    private boolean codeAccess;

    /**
     * Should start without access to code and with 0 code check ins
     * @param name
     */
    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = false; // without access
        this.checkIns = 0;
    }

    public boolean getCodeAccess() {
        return this.codeAccess;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    public int getSuccessfulCheckIns() {
        return this.checkIns;
    }

    public boolean checkInCode() {
        // break if SE doesn't have a manager
        if(this.getManager() == null) {
            return false;
        }

        TechnicalLead TL = (TechnicalLead) this.getManager();
        if(TL.approveCheckIn(this)) {
            this.checkIns = getSuccessfulCheckIns() + 1;
            return true;
        } else {
            this.setCodeAccess(false);
            return false;
        }
    }

}
