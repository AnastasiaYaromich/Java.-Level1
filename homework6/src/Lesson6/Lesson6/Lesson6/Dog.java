package Lesson6;

public class Dog extends Animal {
    protected String voice;

    public Dog(String name, String color, int age, String voice) {
        super(name, color, age);
        this.voice = voice;
        System.out.println("new Dog");
    }

    @Override
    void run(int length) {
        if (length > 500 || length < 0) {
            System.out.println("Ошибка! Задайте другую дистацию");
        } else {
            System.out.println(name + " пробежал " + length + " м.");
        }
    }

    @Override
    void swim(int length) {
        if (length > 10 || length < 0) {
            System.out.println("Ошибка! Задайте другую дистанцию");
        } else {
            System.out.println(name + " проплыл " + length + " м.");
        }

    }
}


