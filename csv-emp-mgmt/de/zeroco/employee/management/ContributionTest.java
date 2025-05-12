package de.zeroco.employee.management;

//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Arrays;
import java.util.List;
//import com.opencsv.CSVWriter;

public class ContributionTest {

//    public static void main(String[] args) {
//        ContributionService service = new ContributionService();
//        SaveValidContribution(service);
//        SaveWithInvalidFrom(service);
//        SaveWithInvalidTo(service);
//        SaveWithNegativeAmount(service);
//        SaveWithInvalidDate(service);
//        SaveWithInvalidCreditOrDebit(service);
//        ListContributions(service);
//        DeleteExistingContribution(service);
//        DeleteNonExistingContribution(service);
//        ListContributionsAfterDeletion(service);
//    }

    public static void SaveValidContribution(ContributionService service) {
        Contribution contribution = new Contribution("2025-01-01", "f1", "f2", 5000.0f, "debit", "f1 given money to f2");
        System.out.println("Test Save Valid Contribution: " + service.save(contribution));
    }

    public static void SaveWithInvalidFrom(ContributionService service) {
        Contribution contribution = new Contribution("2025-01-01", "invalid", "f2", 5000.0f, "debit", "Invalid from user");
        System.out.println("Test Save Contribution with Invalid From: " + service.save(contribution));
    }

    public static void SaveWithInvalidTo(ContributionService service) {
        Contribution contribution = new Contribution("2025-01-01", "f1", "invalid", 5000.0f, "debit", "Invalid to user");
        System.out.println("Test Save Contribution with Invalid To: " + service.save(contribution));
    }

    public static void SaveWithNegativeAmount(ContributionService service) {
        Contribution contribution = new Contribution("2025-01-01", "f1", "f2", -5000.0f, "debit", "Negative amount");
        System.out.println("Test Save Contribution with Negative Amount: " + service.save(contribution));
    }

    public static void SaveWithInvalidDate(ContributionService service) {
        Contribution contribution = new Contribution("2026-01-01", "f1", "f2", 5000.0f, "debit", "Future date");
        System.out.println("Test Save Contribution with Future Date: " + service.save(contribution));
    }

    public static void SaveWithInvalidCreditOrDebit(ContributionService service) {
        Contribution contribution = new Contribution("2025-01-01", "f1", "f2", 5000.0f, "invalid", "Invalid credit/debit");
        System.out.println("Test Save Contribution with Invalid Credit/Debit: " + service.save(contribution));
    }

    public static void ListContributions(ContributionService service) {
        List<Contribution> contributions = ContributionService.list();
        System.out.println("Test List Contributions: ");
        for (Contribution contribution : contributions) {
            System.out.println(contribution);
        }
    }

    public static void DeleteExistingContribution(ContributionService service) {
        System.out.println("Test Delete Existing Contribution: " + 
            ContributionService.delete("2025-01-01", "f1", "f2", 5000));
    }

    public static void DeleteNonExistingContribution(ContributionService service) {
        System.out.println("Test Delete Non-Existing Contribution: " + 
            ContributionService.delete("2025-02-01", "f3", "f4", 9999));
    }

    public static void ListContributionsAfterDeletion(ContributionService service) {
        List<Contribution> contributionsAfterDeletion = ContributionService.list();
        System.out.println("Test List Contributions After Deletion: ");
        for (Contribution contribution : contributionsAfterDeletion) {
            System.out.println(contribution);
        }
    }
    
}
