package joyceArrays;

public class Student {
    private int id;
    private CollegeCourse[] courses;

    public Student(int id) {
        this.id = id;
        this.courses = new CollegeCourse[5];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CollegeCourse getCourse(int index) {
        return courses[index];
    }

    public void setCourse(CollegeCourse course, int index) {
        this.courses[index] = course;
    }

}
