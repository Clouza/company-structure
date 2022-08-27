package net.clouza.company.technical;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
class SoftwareEngineerTest {
    TechnicalLead TL = new TechnicalLead("TestLead");
    SoftwareEngineer SE = new SoftwareEngineer("Test");

    @Test
    void checkInCodeReturnFalse() {
        TL.addReport(SE);
        SE.setCodeAccess(false);

        assertEquals(false, SE.checkInCode());
    }

    @Test
    void checkInCodeReturnTrue() {
        TL.addReport(SE);
        SE.setCodeAccess(true);

        assertEquals(true, SE.checkInCode());
    }

    /**
     * Summary
     * checkInCode() - return boolean
     * will return true, if the Software Engineer has been adding to the TechnicalLead report & code access is true
     * will return false, if the Software Engineer has been adding to the TechnicalLead report & code access is false
     */

}