package joyceInheritance.turner;

public class Record implements Turner{
    @Override
    public void turn() {
        System.out.println("Flipping the record side");
    }
}
