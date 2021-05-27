package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    // Определим размеры игрового поля. Пусть будет 5х5.
    // Для этого оздадим две переменные типа int и инициализуем их значением 5.
    static final int SIZE_X = 5;
    static final int SIZE_Y = 5;

    // Определим количество символов для победы. Например, если поле
    // размером 5х5, то победной серией будем считать 4 одинаковых символа подряд
    // (игрока или компьютера) расположнных по гозиронтали, вертикали или диагоналям.
    // вертикали и диагоналям.
    static final int SIZE_TO_WIN = 4;

    // Создадим игровое поле в виде массива типа char, в который будут
    // размещаться крестики и нолики (ходы игрока и компьютера).
    static char[][] playfield = new char[SIZE_Y][SIZE_X];

    // Созданим символы (крестики и нолики), используемые игроком и компьютером, а также
    // символ для обозначени пустого поля.
    public static final char EMPTY_DOT = '*';
    public static final char PLAYER_DOT = 'X';
    public static final char ARTINTEL_DOT = 'O';

    // Иницилизируем ячейки поля символами, обозначающими пустое поле.
    public static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                playfield[i][j] = EMPTY_DOT;
            }
        }
    }

    // Выведем игровое поле на экран.
    public static void printField() {
        for (int i = 0; i < SIZE_Y + 1; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print((i + 1) + " ");
            System.out.print("| ");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(playfield[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Создадим метод для установки символа
    // (игрока или компьютера) в ячейку поля
    public static void setSymb(int y, int x, char dot) {
        playfield[y][x] = dot;
    }

    // Созданим метод для проверки возможности совершения хода (игрока
    // или компьютера) в ту или иную ячейку поля
    public static boolean isCellValid(int y, int x) {

        // Проверим находится ли совершаемый ход в пределах массива, если
        // не находится возвращаем в точку вызова значение false и
        // нам снова предлагают совершить ход
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        // Проверим являетс ли место для совершения хода свободным.
        // Если не явялется возвращаем в точку вызова значение false и
        // нам снова предлагают совершить ход
        return playfield[y][x] == EMPTY_DOT;
    }

    // Создадим объекты классов сканер и рандом для возможности
    // задания значений (игрок) и генерации значений(компьютер).
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();

    // Cоздадим метод для хода игрока.
    public static void playerStep() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты X, Y (1-5): ");
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;
        } while (!isCellValid(y, x));
        setSymb(y, x, PLAYER_DOT);
    }

    // Создадим метод для хода компьютера.
    public static void artintelStep() {
        int x;
        int y;

        // Попытаемся заблокрировать ходы игрока
        // От каждой точки массива (игрового поля) будем ходить по четырем
        // направлениям и проверять есть ли у игрока шанс выиграть и блокировать
        // этот шанс.
        for (int vert = 0; vert < SIZE_Y; vert++) {
            for (int hor = 0; hor < SIZE_X; hor++) {

                // В текущей точке игрового поля проверим:
                // 1. Помещается ли по горизонтали 4 ячейки
                // 2. Если помещается, проверяем находятся ли там 3 хода игрока
                // подряд с помощью метода checkLineOnHorizont().
                // 3. Если находятся с помощью метода MoveAiLineHorizont() блокируем
                // ход игрока (ставим в четвертую ячейку при условии, что она пустая - нолик.
                if (hor + SIZE_TO_WIN <= SIZE_X) {
                    if (checkLineOnHorizont(vert, hor, PLAYER_DOT) == SIZE_TO_WIN - 1) {
                        if (MoveAiLineHorizont(vert, hor, ARTINTEL_DOT)) return;
                    }

                    // В текущей точке игрового поля проверим:
                    // 1. Помещается ли по диагонали вверх 4 ячейки
                    // 2. Если помещается, проверяем находятся ли там 3 хода игрока
                    // подряд с помощью метода checkDiagUp().
                    // 3. Если находятся с помощью метода MoveAiDiaUp() блокируем
                    // ход игрока (ставим в четвертую ячейку при условии, что она пустая - нолик.
                    if (vert - SIZE_TO_WIN > -2) {
                        if (checkDiagUp(vert, hor, PLAYER_DOT) == SIZE_TO_WIN - 1) {
                            if (MoveAiDiaUp(vert, hor, ARTINTEL_DOT)) return;
                        }
                    }

                    // В текущей точке игрового поля проверим:
                    // 1. Помещается ли по диагонали вниз 4 ячейки
                    // 2. Если помещается, проверяем находятся ли там 3 хода игрока
                    // подряд с помощью метода checkDiagDown().
                    // 3. Если находятся с помощью метода MoveAiDiaDown() блокируем
                    // ход игрока (ставим в четвертую ячейку при условии, что она пустая - нолик.
                    if (vert + SIZE_TO_WIN <= SIZE_Y) {
                        if (checkDiagDown(vert, hor, PLAYER_DOT) == SIZE_TO_WIN - 1) {
                            if (MoveAiDiaDown(vert, hor, ARTINTEL_DOT)) return;
                        }
                    }
                }

                // В текущей точке игрового поля проверим:
                // 1. Помещается ли по вертикали 4 ячейки
                // 2. Если помещается, проверяем находятся ли там 3 хода игрока
                // подряд с помощью метода checkLineOnVertical().
                // 3. Если находятся с помощью метода MoveAiLineVertical() блокируем
                // ход игрока (ставим в четвертую ячейку при условии, что она пустая - нолик.
                if (vert + SIZE_TO_WIN <= SIZE_Y) {
                    if (checkLineOnVertical(vert, hor, PLAYER_DOT) == SIZE_TO_WIN - 1) {
                        if (MoveAiLineVertical(vert, hor, ARTINTEL_DOT)) return;
                    }
                }
            }
        }


        // Попытаемся выиграть у игрока
        // От каждой точки массива (игрового поля) будем ходить по четырем
        // направлениям и проверять есть ли шанс у компьютера выиграть и если
        // есть ставиь нолик.
        for (int vert = 0; vert < SIZE_Y; vert++) {
            for (int hor = 0; hor < SIZE_X; hor++) {

                // В текущей точке игрового поля проверим:
                // 1. Помещается ли по горизонтали 4 ячейки
                // 2. Если помещается, проверяем находятся ли там 3 хода компьютера
                // подряд с помощью метода checkLineOnHorizont().
                // 3. Если находятся с помощью метода MoveAiLineHorizont()
                // ставим в четвертую ячейку при условии, что она пустая - нолик.
                if (hor + SIZE_TO_WIN <= SIZE_X) {
                    if (checkLineOnHorizont(vert, hor, ARTINTEL_DOT) == SIZE_TO_WIN - 1) {
                        if (MoveAiLineHorizont(vert, hor, ARTINTEL_DOT)) return;
                    }


                    // В текущей точке игрового поля проверим:
                    // 1. Помещается ли по диагонали вверх 4 ячейки
                    // 2. Если помещается, проверяем находятся ли там 3 хода компьютера
                    // подряд с помощью метода checkDiagUp().
                    // 3. Если находятся с помощью метода MoveAiDiaUp()
                    // ставим в четвертую ячейку при условии, что она пустая - нолик.
                    if (vert - SIZE_TO_WIN > -2) {
                        if (checkDiagUp(vert, hor, ARTINTEL_DOT) == SIZE_TO_WIN - 1) {
                            if (MoveAiDiaUp(vert, hor, ARTINTEL_DOT)) return;
                        }
                    }

                    // В текущей точке игрового поля проверим:
                    // 1. Помещается ли по диагонали вниз 4 ячейки
                    // 2. Если помещается, проверяем находятся ли там 3 хода компьютера
                    // подряд с помощью метода checkDiagDown().
                    // 3. Если находятся с помощью метода MoveAiDiaDown()
                    // ставим в четвертую ячейку при условии, что она пустая - нолик.
                    if (vert + SIZE_TO_WIN <= SIZE_Y) {
                        if (checkDiagDown(vert, hor, ARTINTEL_DOT) == SIZE_TO_WIN - 1) {
                            if (MoveAiDiaDown(vert, hor, ARTINTEL_DOT)) return;
                        }
                    }
                }

                // В текущей точке игрового поля проверим:
                // 1. Помещается ли по вертикали 4 ячейки
                // 2. Если помещается, проверяем находятся ли там 3 хода компьютера
                // подряд с помощью метода checkLineOnVertical().
                // 3. Если находятся с помощью метода MoveAiLineVertical()
                // ставим в четвертую ячейку при условии, что она пустая - нолик.
                if (vert + SIZE_TO_WIN <= SIZE_Y) {
                    if (checkLineOnVertical(vert, hor, ARTINTEL_DOT) == SIZE_TO_WIN - 1) {
                        if (MoveAiLineVertical(vert, hor, ARTINTEL_DOT)) return;
                    }
                }
            }
        }

        // Если все предыдущие условия не выполнились
        // и ход не был совершем компьютер совершает
        // рандомный ход
        do {
            x = rand.nextInt(SIZE_X);
            y = rand.nextInt(SIZE_Y);
        } while (!isCellValid(y, x));
        setSymb(y, x, ARTINTEL_DOT);
    }

    // Метод для блокировки хода игрока по горизонтали
    // Из точки массива в которой находимся и из которой проводим проверку
    // идем по горизонтали вправо и если находим пустое значение - ставим нолик.
    public static boolean MoveAiLineHorizont(int vert, int hor, char dot) {
        for (int j = hor; j < SIZE_TO_WIN; j++) {
            if (playfield[vert][j] == EMPTY_DOT) {
                playfield[vert][j] = dot;
                return true;
            }
        }
        return false;
    }

    // Метод для блокировки хода игрока по вертикали.
    // Из точки массива в которой находимся и из которой проводим проверку
    // идем по вертикали вправо и если находим пустое значение - ставим нолик.
    public static boolean MoveAiLineVertical(int vert, int hor, char dot) {
        for (int i = vert; i < SIZE_TO_WIN; i++) {
            if (playfield[i][hor] == EMPTY_DOT) {
                playfield[i][hor] = dot;
                return true;
            }
        }
        return false;
    }

    // Метод для блокировки хода игрока по диагонали вверх
    // Из точки массива в которой находимся и из которой проводим проверку
    // идем по диагонали вверх и если находим пустое значение - ставим нолик.
    public static boolean MoveAiDiaUp(int vert, int hor, char dot) {
        for (int i = 0, j = 0; j < SIZE_TO_WIN; i--, j++) {
            if (playfield[vert + i][hor + j] == EMPTY_DOT) {
                playfield[vert + i][hor + j] = dot;
            }
        }
        return false;
    }

      // Метод для блокировки хода игрока по диагонали вниз
    // Из точки массива в которой находимся и из которой проводим проверку
    // идем по диагонали вниз и если находим пустое значение - ставим нолик.

    public static boolean MoveAiDiaDown(int vert, int hor, char dot) {
        for (int i = 0; i < SIZE_TO_WIN; i++) {
            if (playfield[vert + i][hor + i] == EMPTY_DOT) {
                playfield[vert + i][hor + i] = dot;
            }
        }
        return false;
    }


    // Создадим метод для проверки победы
    // Попытаемся найти победную серию ходов.
    // От каждой точки массива (игрового поля) будем ходить по четырем
    // направлениям и проверять есть ли выигрышная комбинация у игрока
    // либо у компьютера.
    public static boolean checkWin(char dot) {
        for (int vert = 0; vert < SIZE_Y; vert++) {
            for (int hor = 0; hor < SIZE_X; hor++) {
                // В текущей точке игрового поля проверим:
                // 1. Помещается ли по горизонтали 4 ячейки
                // 2. Если помещается, проверяем находятся ли там 4 хода компьютера
                // либо игрока подряд с помощью метода checkLineOnHorizont.
                // 3. Если находятся возвращаем true в точку вызова
                // метода checkWin и выводим сообщение о выигрыше игрока либо компьютера.
                if (hor + SIZE_TO_WIN <= SIZE_X) {
                    if (checkLineOnHorizont(vert, hor, dot) >= SIZE_TO_WIN) return true;

                    // В текущей точке игрового поля проверим:
                    // 1. Помещается ли по диагонали вверх 4 ячейки
                    // 2. Если помещается, проверяем находятся ли там 4 хода компьютера
                    // либо игрока подряд с помощью метода checkDiagUp.
                    // 3. Если находятся возвращаем true в точку вызова
                    // метода checkWin и выводим сообщение о выигрыше игрока либо компьютера.
                    if (vert - SIZE_TO_WIN > -2) {
                        if (checkDiagUp(vert, hor, dot) >= SIZE_TO_WIN) return true;
                    }

                    // В текущей точке игрового поля проверим:
                    // 1. Помещается ли по диагонали вниз 4 ячейки
                    // 2. Если помещается, проверяем находятся ли там 4 хода компьютера
                    // либо игрока подряд с помощью метода checkDiagDown.
                    // 3. Если находятся возвращаем true в точку вызова
                    // метода checkWin и выводим сообщение о выигрыше игрока либо компьютера.
                    if (vert + SIZE_TO_WIN <= SIZE_Y) {
                        if (checkDiagDown(vert, hor, dot) >= SIZE_TO_WIN) return true;
                    }
                }

                // В текущей точке игрового поля проверим:
                // 1. Помещается ли по вертикали 4 ячейки
                // 2. Если помещается, проверяем находятся ли там 4 хода компьютера
                // либо игрока подряд с помощью метода checkLineOnVertical.
                // 3. Если находятся возвращаем true в точку вызова
                // метода checkWin и выводим сообщение о выигрыше игрока либо компьютера.
                if (vert + SIZE_TO_WIN <= SIZE_Y) {
                    if (checkLineOnVertical(vert, hor, dot) >= SIZE_TO_WIN) return true;
                }
            }
        }
        return false;
    }


    // Метод для подсчета количества совершенных ходов игрока
    // или компьютера по диагонали вверх.
    public static int checkDiagUp(int vert, int hor, char dot) {
        int count = 0;
        for (int i = 0, j = 0; j < SIZE_TO_WIN; i--, j++) {
            if (playfield[vert + i][hor + j] == dot) count++;
        }
        return count;
    }

    // Метод для подсчета количества совершенных ходов игрока
    // или компьютера по диагонали вниз.
    public static int checkDiagDown(int vert, int hor, char dot) {
        int count = 0;
        for (int i = 0; i < SIZE_TO_WIN; i++) {
            if ((playfield[vert + i][hor + i] == dot)) count++;
        }
        return count;
    }

    // Метод для подсчета количества совершенных ходов игрока
    // или компьютера по горизонтали.
    public static int checkLineOnHorizont(int vert, int hor, char dot) {
        int count = 0;
        for (int j = hor; j < SIZE_TO_WIN + hor; j++) {
            if (playfield[vert][j] == dot) count++;
        }
        return count;
    }

    // Метод для подсчета количества совершенных ходов игрока
    // или компьютера по вертикали диагонали вниз.
    public static int checkLineOnVertical(int vert, int hor, char dot) {
        int count = 0;
        for (int i = vert; i < SIZE_TO_WIN + vert; i++) {
            if (playfield[i][hor] == dot) count++;
        }
        return count;
    }


    // Создадим метод для проверки заполнено ли поле.
    public static boolean isfieldFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (playfield[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // Инициализируем и выводим на печать поле.
        initField();
        printField();


        // Играем пока не победим или будет ничья.
        while (true) {
            playerStep();
            printField();
            if (checkWin(PLAYER_DOT)) {
                System.out.println("Победил человек!");
                break;
            }
            if (isfieldFull()) {
                System.out.println("Ничья");
                break;
            }

            artintelStep();
            printField();
            if (checkWin(ARTINTEL_DOT)) {
                System.out.println("Победил исскуственный интеллект!");
                break;
            }
            if (isfieldFull()) {
                System.out.println("Ничья");
                break;
            }

        }
    }

}
