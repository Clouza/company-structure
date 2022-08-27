package net.clouza.company;

import net.clouza.company.business.BusinessLead;
import net.clouza.company.business.Accountant;
import net.clouza.company.technical.TechnicalLead;
import net.clouza.company.technical.SoftwareEngineer;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public class CompanyStructure {
    public static void main(String[] args) {
        TechnicalLead CTO = new TechnicalLead("Satya Nadella");

        SoftwareEngineer seA = new SoftwareEngineer("Kasey"); // 75000 * 1.1
        SoftwareEngineer seB = new SoftwareEngineer("Breana");
        SoftwareEngineer seC = new SoftwareEngineer("Eric");

        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);

        System.out.println("[ Technical ][Team 1]");
        seA.setCodeAccess(true); // allow check in
        seB.setCodeAccess(true);
        seC.setCodeAccess(false);

        seA.checkInCode();
        seB.checkInCode();
        seC.checkInCode();

        System.out.println(CTO.getTeamStatus());

        TechnicalLead VPofENG = new TechnicalLead("Bill Gates");
        SoftwareEngineer seD = new SoftwareEngineer("Winter");
        SoftwareEngineer seE = new SoftwareEngineer("Libby");
        SoftwareEngineer seF = new SoftwareEngineer("Gizan");
        SoftwareEngineer seG = new SoftwareEngineer("Zaynah");

        VPofENG.addReport(seD);
        VPofENG.addReport(seE);
        VPofENG.addReport(seF);
        VPofENG.addReport(seG);

        System.out.println("[ Technical ][Team 2]");
        seD.setCodeAccess(true);
        seE.setCodeAccess(true);
        seF.setCodeAccess(true);
        seG.setCodeAccess(true);

        seD.checkInCode();
        seE.checkInCode();
        seF.checkInCode();
        seG.checkInCode();

        System.out.println(VPofENG.getTeamStatus());

        BusinessLead CFO = new BusinessLead("Amy Hood");

        Accountant actA = new Accountant("Niky");
        Accountant actB = new Accountant("Andrew");

        CFO.addReport(actA, CTO);
        CFO.addReport(actB, VPofENG);
        System.out.println("[ Business ]");

        System.out.println(CFO.getTeamStatus());

        System.out.println("------------------------------");
        CTO.setManager(CFO);
        VPofENG.setManager(CFO);

        System.out.printf("%s requested bonus for $%d and %s. \n", seA.toString(), 100000, CTO.requestBonus(seA, 100000) ? "approved" : "not approved");
        System.out.printf("%s requested bonus for $%d and %s. \n", seB.toString(), 100000, CTO.requestBonus(seB, 100000) ? "approved" : "not approved");

        System.out.println("\n[ Current Status ]\n" + CFO.getTeamStatus());

        System.out.println("------------------------------");
        System.out.printf("%s wants to have some money for the weekends. That's why she is requested bonus for %d and %s.\n", actA.toString(), 100000, CFO.requestBonus(actA, 100000) ? "approved" : "not approved");
        System.out.printf("%s wants to have some money for the weekends. That's why she is requested bonus for %d and %s.\n", actB.toString(), 200000, CFO.requestBonus(actB, 200000) ? "approved" : "not approved");

        System.out.println("\n[ Current Status ]\n" + CFO.getTeamStatus());


    }
}