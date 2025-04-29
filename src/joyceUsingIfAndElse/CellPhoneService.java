package joyceUsingIfAndElse;

import java.util.Scanner;

public class CellPhoneService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Horizon Phones: Cellular Phone Service Plan Recommendation");
        System.out.println("-------------------------------------------------------------------");

        System.out.print("Enter maximum monthly talk minutes: ");
        int talkMinutes = scanner.nextInt();

        System.out.print("Enter maximum monthly text messages: ");
        int textMessages = scanner.nextInt();

        System.out.print("Enter maximum monthly data (in gigabytes): ");
        int dataGB = scanner.nextInt();

        String plan = getRecommendedPlan(talkMinutes, textMessages, dataGB);
        System.out.println("Recommended plan: " + plan);
    }

    public static String getRecommendedPlan(int talkMinutes, int textMessages, int dataGB) {
        if (talkMinutes < 500 && textMessages == 0 && dataGB == 0) {
            return "Plan A ($49/month)";
        } else if (talkMinutes < 500 && textMessages > 0) {
            return "Plan B ($55/month)";
        } else if (talkMinutes >= 500 && dataGB == 0) {
            if (textMessages <= 100) {
                return "Plan C ($61/month)";
            } else {
                return "Plan D ($70/month)";
            }
        } else if (dataGB > 0) {
            if (dataGB <= 3) {
                return "Plan E ($79/month)";
            } else {
                return "Plan F ($87/month)";
            }
        }
        return "Unknown plan";
    }

}
