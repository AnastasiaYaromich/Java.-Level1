package Lesson5;

import java.util.Arrays;

// Task 1. Создать класс сотрудник с полями: ФИО, должность,
// email, телефон, зарплата, возраст.
public class Worker {

    private String fullName;   // поле для хранения ФИО
    private String post;      // поле для хранения должности
    private String email;        // поле для хранения эл.почты
    private String phoneNumber;  // поле для хранения номера телефона
    private int salary;          // поле для хранения заработной платы
    private int age;            // поле для хранения возраста


    // Task 2. Конструктор класса должен заполнять
    // эти поля при создании объекта.
    public Worker(String fullName, String post,
                  String email, String phoneNumber,
                  int salary, int age) {
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;

    }

    // Task 3. Внутри класса «Сотрудник» написать метод,
    // который выводит информацию об объекте в консоль.
    public void InfoWorker() {
        System.out.println("ФИО: " + fullName + "; Должность: " + post + "; Email: " + email
                + "; Номер телефона: " + phoneNumber + "; Зарплата: " + salary + "; Возраст: " + age);
    }

    public int getAge() {
        return age;
    }

}





