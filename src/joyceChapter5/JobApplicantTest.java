package joyceChapter5;

public class JobApplicantTest {
    public static void main(String[] args) {
        JobApplicant applicant1 = new JobApplicant("John Doe", "123-456-7890", true, true, true, false);
        JobApplicant applicant2 = new JobApplicant("Jane Smith", "987-654-3210", true, false, false, false);
        JobApplicant applicant3 = new JobApplicant("Bob Johnson", "555-123-4567", true, true, false, true);

        System.out.println(applicant1.getName() + ": " + (isQualified(applicant1) ? "Qualified" : "Not Qualified"));
        System.out.println(applicant2.getName() + ": " + (isQualified(applicant2) ? "Qualified" : "Not Qualified"));
        System.out.println(applicant3.getName() + ": " + (isQualified(applicant3) ? "Qualified" : "Not Qualified"));
    }

    public static boolean isQualified(JobApplicant applicant) {
        int skills = 0;
        if (applicant.isWordProcessing()) skills++;
        if (applicant.isSpreadsheets()) skills++;
        if (applicant.isDatabases()) skills++;
        if (applicant.isGraphics()) skills++;
        return skills >=3;
}

}
