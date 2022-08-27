package net.clouza.company.technical;

import net.clouza.company.business.Accountant;
import net.clouza.company.business.BusinessLead;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
class TechnicalLeadTest {
    TechnicalLead TL = new TechnicalLead("TechnicalLead");
    SoftwareEngineer SE = new SoftwareEngineer("SoftwareEngineer");

    BusinessLead BL = new BusinessLead("BusinessLead");
    Accountant AC = new Accountant("Accountant");

    @Test
    void requestBonusReturnTrue() {
        TL.addReport(SE);
        BL.addReport(AC, TL);

        TL.setManager(BL);
        assertEquals(true, TL.requestBonus(SE, 1000));
    }

    @Test
    void requestBonusReturnFalse() {
        TL.addReport(SE);
        BL.addReport(AC, TL);

        TL.setManager(BL);
        assertEquals(false, TL.requestBonus(SE, 20000000));
    }

    /**
     * Summary
     * Bonuses will be obtained if the budget is still available
     */
}