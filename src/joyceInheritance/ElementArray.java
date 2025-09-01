package joyceInheritance;

public class ElementArray {
    public static void main(String[] args) {
        Element[] elements = new Element[4];

        elements[0] = new MetalElement("Fe", 26, 55.85);
        elements[1] = new MetalElement("Cu", 29, 63.55);
        elements[2] = new NonMetalElement("C", 6, 12.01);
        elements[3] = new NonMetalElement("N", 7, 14.01);

        for (Element element : elements) {
            element.describeElement();
            System.out.println();
        }
    }
}
