package joyceInheritance;

public class DemoPhoneCalls {
    public static void main(String[] args) {
        PhoneCall incomingCall = new IncomingPhoneCall("123-456-7890");
        PhoneCall outgoingCall = new OutgoingPhoneCall("987-654-3210", 10);

        System.out.println("Incoming Call:");
        incomingCall.display();
        System.out.println();

        System.out.println("Outgoing Call:");
        outgoingCall.display();
    }
}
