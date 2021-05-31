package Lesson6;

abstract class Animal {
    protected String color;
    protected String name;
    protected int age;

    public Animal(String name, String color, int age) {
        System.out.println("new Animal");
        this.name = name;
        this.color = color;
        this.age = age;
    }

    abstract void run(int length);
    abstract void swim(int length);

    static int counter(Animal a[]) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            count++;
        }
        return count;
    }
    }

