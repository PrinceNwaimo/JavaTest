package joyceInheritance;

public class DemoBlankets {
    public static void main(String[] args) {
        Blanket blanket = new Blanket();
        blanket.setSize("Queen");
        blanket.setMaterial("wool");
        blanket.setColor("blue");
        System.out.println("Blanket:");
        System.out.println(blanket.toString());
        System.out.println();

        ElectricBlanket electricBlanket = new ElectricBlanket();
        electricBlanket.setSize("King");
        electricBlanket.setMaterial("cashmere");
        electricBlanket.setColor("red");
        electricBlanket.setHeatSettings(3);
        electricBlanket.setAutomaticShutoff(true);
        System.out.println("Electric Blanket:");
        System.out.println(electricBlanket.toString());
    }
}
