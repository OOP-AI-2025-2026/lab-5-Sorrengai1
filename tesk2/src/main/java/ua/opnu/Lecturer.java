package ua.opnu;

/**
 * Клас Викладач, який успадковується від Person
 */
public class Lecturer extends Person {
    private String department;
    private double salary;

    /**
     * Конструктор класу Lecturer
     * @param lastName прізвище
     * @param firstName ім'я
     * @param age вік
     * @param department кафедра
     * @param salary заробітна плата
     */
    public Lecturer(String lastName, String firstName, int age, String department, double salary) {
        super(lastName, firstName, age);
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Викладач кафедри " + department + ", " + getLastName() + " " + getFirstName()
                + ", вік: " + getAge() + ". Зарплата: " + salary;
    }
}
