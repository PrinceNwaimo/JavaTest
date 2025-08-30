package joyceInheritance;

public class LessonWithRental extends Rental{
    private boolean lessonRequired;
    private static final String[] INSTRUCTORS = {"John", "Mary", "David", "Emily", "James", "Sarah", "Michael", "Jessica"};

    public LessonWithRental(int contractNumber, int minutes, int equipmentType) {
        super(contractNumber, minutes, equipmentType);
        lessonRequired = equipmentType == 1 || equipmentType == 2;
    }

    public String getInstructor() {
        return "Equipment Type: " + getEquipmentTypeName() +
                "\nLesson Required: " + (lessonRequired ? "Yes" : "No") +
                "\nInstructor: " + INSTRUCTORS[getEquipmentType() - 1];
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n" + getInstructor();
    }
}
