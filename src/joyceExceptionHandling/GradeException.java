package joyceExceptionHandling;

public class GradeException extends Exception{
    public static final String[] VALID_GRADES = {"A", "B", "C", "D", "F", "I"};

    public GradeException(String message) {
        super(message);
    }

    public static boolean isValidGrade(String grade) {
        for (String validGrade : VALID_GRADES) {
            if (grade.equalsIgnoreCase(validGrade)) {
                return true;
            }
        }
        return false;
    }
}
