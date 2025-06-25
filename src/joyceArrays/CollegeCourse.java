package joyceArrays;

public class CollegeCourse {
    private String courseId;
    private int creditHours;
    private String grade;

    public CollegeCourse(String courseId, int creditHours, String grade) {
        this.courseId = courseId;
        this.creditHours = creditHours;
        this.grade = grade;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Credit Hours: " + creditHours + ", Grade: " + grade;
    }

}
