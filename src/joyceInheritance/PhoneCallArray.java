package joyceInheritance;

public class PhoneCallArray {
    public static void main(String[] args) {
        PhoneCall[] phoneCalls = new PhoneCall[8];

        phoneCalls[0] = new IncomingPhoneCall("123-456-7890");
        phoneCalls[1] = new OutgoingPhoneCall("987-654-3210", 10);
        phoneCalls[2] = new IncomingPhoneCall("555-123-4567");
        phoneCalls[3] = new OutgoingPhoneCall("765-432-1098", 5);
        phoneCalls[4] = new IncomingPhoneCall("901-234-5678");
        phoneCalls[5] = new OutgoingPhoneCall("111-222-3333", 15);
        phoneCalls[6] = new IncomingPhoneCall("444-555-6666");
        phoneCalls[7] = new OutgoingPhoneCall("777-888-9999", 20);

        for (PhoneCall phoneCall : phoneCalls) {
            phoneCall.display();
            System.out.println();
        }
    }
}
