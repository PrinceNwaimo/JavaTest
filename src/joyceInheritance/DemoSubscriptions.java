package joyceInheritance;

public class DemoSubscriptions {
    public static void main(String[] args) {
        PhysicalNewspaperSubscription physicalSub1 = new PhysicalNewspaperSubscription();
        physicalSub1.setName("John Doe");
        physicalSub1.setAddress("123 Main St");
        System.out.println("Physical Subscription:");
        System.out.println("Name: " + physicalSub1.getName());
        System.out.println("Address: " + physicalSub1.getAddress());
        System.out.println("Rate: $" + physicalSub1.getRate());

        PhysicalNewspaperSubscription physicalSub2 = new PhysicalNewspaperSubscription();
        physicalSub2.setName("Jane Doe");
        physicalSub2.setAddress("No digits here");
        System.out.println("\nPhysical Subscription:");
        System.out.println("Name: " + physicalSub2.getName());
        System.out.println("Address: " + physicalSub2.getAddress());
        System.out.println("Rate: $" + physicalSub2.getRate());

        OnlineNewspaperSubscription onlineSub1 = new OnlineNewspaperSubscription();
        onlineSub1.setName("Bob Smith");
        onlineSub1.setAddress("bob.smith@example.com");
        System.out.println("\nOnline Subscription:");
        System.out.println("Name: " + onlineSub1.getName());
        System.out.println("Address: " + onlineSub1.getAddress());
        System.out.println("Rate: $" + onlineSub1.getRate());

        OnlineNewspaperSubscription onlineSub2 = new OnlineNewspaperSubscription();
        onlineSub2.setName("Alice Johnson");
        onlineSub2.setAddress("no at sign here");
        System.out.println("\nOnline Subscription:");
        System.out.println("Name: " + onlineSub2.getName());
        System.out.println("Address: " + onlineSub2.getAddress());
        System.out.println("Rate: $" + onlineSub2.getRate());
    }
}
