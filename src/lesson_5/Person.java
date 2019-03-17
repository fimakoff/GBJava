package lesson_5;

public class Person {
    private String name;
    private String position;
    private String email;
    private String tel;
    private int salary;
    private int age;

    public Person(String name, String position, String email, String tel, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("NAME: " + name + ",  POSITION: " + position + ",  EMAIL: " + email +
                "  TEL: " + tel + ",  SALARY: " + salary + ",  AGE: " + age);
    }
}
