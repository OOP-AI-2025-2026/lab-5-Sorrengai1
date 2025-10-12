package ua.opnu;

/**
 * Клас Студент, який успадковується від Person
 */
public class Student extends Person {
    private String group;
    private String studentId;

    /**
     * Конструктор класу Student
     * @param lastName прізвище
     * @param firstName ім'я
     * @param age вік
     * @param group група
     * @param studentId номер студентського квитка
     */
    public Student(String lastName, String firstName, int age, String group, String studentId) {
        super(lastName, firstName, age);
        this.group = group;
        this.studentId = studentId;
    }

    public String getGroup() {
        return group;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    @Override
    public String toString() {
        return "Студент групи " + group + ", "
                + getLastName() + " " + getFirstName()
                + ", вік: " + getAge() + ". Номер студентського квитка: " + studentId;
    }
}
