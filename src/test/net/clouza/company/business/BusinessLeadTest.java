package net.clouza.company.business;

import net.clouza.company.technical.TechnicalLead;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
class BusinessLeadTest {
    TechnicalLead TL = new TechnicalLead("TechnicalLead");

    BusinessLead BL = new BusinessLead("BusinessLead");
    Accountant AC = new Accountant("Accountant");

    @Test
    void requestBonusReturnTrue() {
        BL.addReport(AC, TL);
        assertEquals(true, BL.requestBonus(AC, 1000));
    }

    @Test
    void requestBonusReturnFalse() {
        BL.addReport(AC, TL);
        assertEquals(false, BL.requestBonus(AC, 20000000));
    }

    /**
     * Summary
     * Bonuses will be obtained if the budget is still available
     */
}