package Lesson3;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        guessNumber();
        guessWord();
        task3();
    }

    // Task №1. Написать программу, которая загадывает случайное
    // число от 0 до 9, и пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить больше ли указанное пользователем
    // число чем загаданное, или меньше.
    // После победы или проигрыша выводится запрос –
    // «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    public static void guessNumber() {

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int count = 0;

        do {
            // Программа загадывает число, находящееся в пределах от 0 до 9
            int x = rand.nextInt(9);
            System.out.println("Программа загадала число от 0 до 9. Попробуйте его угадать.");

            for (count = 0; count < 3; count++) {
                System.out.println("Введите предполагаемое число:");
                // Пользователь пытается угадать число, загаданное программой
                int y = scan.nextInt();
                if (x < y) {
                    System.out.println("К сожалению вы не угадали. Указанное Вами число " +
                            "больше чем загаданное программой");
                }
                if (x > y) {
                    System.out.println("К сожалению вы не угадали.Указанное Вами число " +
                            "меньше чем загаданное программой");
                }
                if (x == y) {
                    System.out.println("Вы угадали число загаданное программой!");
                    break;
                }
            }
            System.out.println("Повторить игру еще раз? 1 - да, 0 - нет");
        }
        while (scan.next().equals("1"));
    }

    // Task №2 Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana",
    // "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
    // "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
    // "pear", "pepper", "pineapple", "pumpkin", "potato"};
    public static void guessWord() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        boolean winner = false;

        // Программа загадывает слово из массива
        int rand = random.nextInt(words.length);

        String worduser;
        String wordcomp = words[rand];

        System.out.println("Компьютер загадал слово из массива words. " +
                "Попробуйте его угадать:");

        do {
            // Пользователь пытается угадать слово загаданное компьютером
            worduser = sc.next();

            if (wordcomp.equals(worduser.toLowerCase())) {
                winner = true;

            }

            if (!winner) {
                System.out.println("Вы не угадали слово загаданное компьютером. Попробуйте снова");

                for (int i = 0; i < wordcomp.length(); i++) {
                    if (i < worduser.length() && wordcomp.charAt(i) == worduser.charAt(i)) {
                        sb.append(worduser.charAt(i));
                    } else sb.append("#");
                }

                System.out.println("Вот буквы, которые " +
                        "Вы угадали: " + sb.toString());
                sb.delete(0, sb.length());
                System.out.println();
            }

        } while (!winner);
            System.out.println("Вы угадали слово загаданное компьютером");
    }

    // Task №3
    static public void task3() {

        String str1 = "Предложение      один    Теперь     предложение два         Предложение            три";
        System.out.println(str1);

        String str2 = str1.replaceAll(" +", " ");
        System.out.println(str2);

        StringBuilder stringBuilder = new StringBuilder(str2);

        for (int i = str2.length() - 1; i > 0; i--) {
            if (str2.charAt(i) >= 'А' && str2.charAt(i) <= 'Я') {
                stringBuilder.setCharAt(i - 1, '.');
                stringBuilder.insert(i, ' ');
            }
        }

       stringBuilder.append('.');

        System.out.println(stringBuilder.toString());


        }

    }
















