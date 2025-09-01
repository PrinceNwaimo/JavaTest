package joyceInheritance.turner;

public class DemoTurners2 {
    public static void main(String[] args) {
        Turner leaf = new Leaf();
        Turner page = new Page();
        Turner pancake = new Pancake();
        Turner record = new Record();
        Turner steeringWheel = new SteeringWheel();

        leaf.turn();
        page.turn();
        pancake.turn();
        record.turn();
        steeringWheel.turn();
    }
}
