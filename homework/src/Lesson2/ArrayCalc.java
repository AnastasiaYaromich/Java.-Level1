package Lesson2;

public class ArrayCalc {

    public static void main(String[] args) {

        // Exercise1.
        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        changeNumber(a);

        // Exercise2.
        int[] b = new int[8];
        fillArray(b, 3, 1);

        // Exercise3.
        int[] c = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        upgradeArray(c);

        // Exercise4.
        diagonalArray(10);

        // Exercise5.
        int[] e = {38, 15, -4, 28, 7, -18, 56, 44, 13, 10};
        minMax(e);

        // Exercise6.
        int[] f = {10, 1, 1, 1, 1, 1, 1, 1, 2, 2};
        System.out.println("Задание №6: " + checkBalance(f));
    }

      /* Exercise1. Замена 1 на 0, 0 на 1 в целочисленном массиве,
      состоящем из 0 и 1 */
      public static void changeNumber(int[] array) {
          for (int i = 0; i < array.length; i++) {
              if (array[i] == 1) {
                  array[i] = 0;
              } else array[i] = 1;
          }
          System.out.print("Задание №1: ");
          for (int i = 0; i < array.length; i++) {
              System.out.print(array[i] + " ");
          }
          System.out.print("\n");
      }

      /* Exercise2. Заполнение пустого массива значениями
      0, 3, 6, 9, 12, 15, 18, 21 */
      public static void fillArray (int [] array, int step, int change) {
          for (int i = 0; i < array.length; i++) {
              if (i == 0) {
                  array[i] = i;
              } else {
                  array[i] = array[i - change] + step;
              }
          }
          System.out.print("Задание №2: ");
          for (int i = 0; i < array.length; i++)
              System.out.print(array[i] + " ");
          System.out.print("\n");
      }

      /* Exercise3. Умножение членов массива меньших 6, на 2 */
      public static void upgradeArray (int[] array) {
          for (int i = 0; i < array.length; i++) {
              if (array[i] < 6) { array[i] = array[i] * 2; }
          }
          System.out.print("Задание №3: ");
          for (int i = 0; i < array.length; i++)
              System.out.print(array[i] + " ");
          System.out.println("\n");
      }

      /* Exercise3. Заполнение диагональных элементов массива единицами */
      public static void diagonalArray (int size) {
        int[][] array = new int[size][size];
        int count = 0;
        System.out.println("Задание №4: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = count;
                if (i == j || j == size - i - 1) { array[i][j] = 1; }
                count++;
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.print("\n");
    }

    /* Exercise5. Нахождение максимального и минимального значения
     в целочисленном массиве*/
     public static void minMax (int [] array) {
        int max, min;
        max = min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) { max = array[i]; }
            if (array[i] < min) { min = array[i]; }
        }
        System.out.println("Задание №5: ");
        System.out.println("Минимальное значение равно: " + min);
        System.out.println("Максимальное значение равно: " + max);
        System.out.print("\n");
    }

       /* Exercise6. Проверка есть ли в массиве место, в
       котором сумма левой и правой части равны*/
    public static boolean checkBalance(int[] f) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < f.length; i++)
            sum2 = sum2 + f[i];

        for (int i = 0; i < f.length; i++) {
            if (sum1 + f[i] == sum2 - (sum1 + f[i])) {
                return true;
            }
            sum1 = sum1 + f[i];
        }
        return false;
    }
}





