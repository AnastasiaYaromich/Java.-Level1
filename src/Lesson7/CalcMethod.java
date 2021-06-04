package Lesson7;

public class CalcMethod {
    public static double Calc(String str, double a, double b) {
        switch (str) {
            case "+":
                double sum = a + b;
                return sum;

            case "-":
                double minus = a - b;
                return minus;

            case "/":
                double div = a / b;
                return div;

            case "*":
                double multipl = a * b;
                return multipl;
        }
        return 0;
    }
}
