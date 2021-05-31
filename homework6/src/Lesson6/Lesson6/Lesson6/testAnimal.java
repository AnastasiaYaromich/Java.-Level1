package Lesson6;

import java.util.Scanner;

public class testAnimal {
    public static void main(String[] args) {
        Animal animal[] = {
                new Cat("Пушинка", "белая", 10, "Мяу!"),
                new Cat("Барсик", "рыжий", 7, "Мяу!"),
                new Cat("Бантик", "черный", 4, "Мяу!"),
                new Cat("Тимоша", "серый", 13, "Мяу!"),
                new Cat("Степан", "белый", 9, "Мяу!"),
                new Dog("Малыш", "серый", 14, "Гав!"),
                new Dog("Тюша", "черный", 17, "Гав!"),
                new Dog("Джуля", "серый", 12, "Гав!"),
                new Dog("Палкан", "черный", 2, "Гав!"),
                new Dog("Джек", "рыжий", 6, "Гав!")
        };

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < animal.length; i++) {
         System.out.println("Задайте параметры для методов run и swim: ");
            int paramrun = scan.nextInt();
            int paramswim = scan.nextInt();
            animal[i].run(paramrun);
            animal[i].swim(paramswim);
           System.out.println();
        }

        System.out.println("Количество созданных животных: " + Animal.counter(animal));

    }
}



