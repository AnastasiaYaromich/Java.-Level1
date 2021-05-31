package Lesson6;

public class Cat extends Animal {
    protected String voice;

    public Cat(String name, String color, int age, String voice) {
        super(name, color, age);
        this.voice = voice;
        System.out.println("new Cat");
    }

    void run(int length) {
        if (length > 200 || length < 0) {
            System.out.println("Ошибка! Задайте другую дистацию");
        } else {
            System.out.println(name + " пробежал " + length + " м.");
        }
    }

    void swim(int length) {
        System.out.println(name + " не умеет плавать.");
    }
}
