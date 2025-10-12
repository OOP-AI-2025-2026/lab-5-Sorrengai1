package ua.opnu;

/**
 * Базовий клас для представлення особи
 */
public class Person {
    private String lastName;
    private String firstName;
    private int age;

    /**
     * Конструктор класу Person
     * @param lastName прізвище
     * @param firstName ім'я
     * @param age вік
     */
    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Людина " + lastName + " " + firstName + ", вік: " + age;
    }
}
