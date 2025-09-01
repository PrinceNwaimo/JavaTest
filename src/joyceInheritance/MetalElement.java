package joyceInheritance;

public class MetalElement extends Element{
    public MetalElement(String symbol, int atomicNumber, double atomicWeight) {
        super(symbol, atomicNumber, atomicWeight);
    }

    @Override
    public void describeElement() {
        System.out.println("Symbol: " + symbol);
        System.out.println("Atomic Number: " + atomicNumber);
        System.out.println("Atomic Weight: " + atomicWeight);
        System.out.println("Metals are good conductors of electricity and are typically shiny and malleable.");
    }
}
