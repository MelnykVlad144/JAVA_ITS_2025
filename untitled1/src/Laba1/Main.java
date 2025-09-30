package Laba1;

public class Main {
    public static void main(String[] args) {

        double a1 = 1.234;
        double b1 = -3.12;
        double c1 = 5.45;
        double d1 = 2.0;

        double res1 = formula1(a1, b1, c1, d1);
        System.out.printf("Formula 1 result: %.5f%n", res1);

        double a2 = 3.56;
        double b2 = 1.02;
        double c2 = 3.0;
        double d2 = 2.43;

        double res2 = formula2(a2, b2, c2, d2);
        System.out.printf("Formula 2 result: %.5f%n", res2);

        double a3 = -2.54;
        double b3 = 1.23;
        double c3 = -2.14;
        double d3 = -0.23;

        double res3 = formula3(a3, b3, c3, d3);
        System.out.printf("Formula 3 result: %.5f%n", res3);
    }

    // Формула 1

    public static double formula1(double a, double b, double c, double d) {
        double numerator = Math.pow(Math.tan(a), 1.0 / c);
        double denominator = 1 + (Math.sinh(b) / Math.log(Math.abs(d + c)));
        return numerator / denominator;
    }


    // Формула 2
    public static double formula2(double a, double b, double c, double d) {
        if (b <= 0 || c == 0 || d / c < 0) return Double.NaN;
        double sqrtPart = Math.sqrt(d / c);
        if (sqrtPart > 1) return Double.NaN; // asin тільки в [-1;1]
        return 2 * Math.log(Math.pow(b, a)) + Math.asin(-sqrtPart);
    }

    // Формула 3
    public static double formula3(double a, double b, double c, double d) {
        if (a == 0 || b == 0) return Double.NaN;
        double inside = Math.cos(c) + Math.pow(Math.E, d);
        if (inside < 0) return Double.NaN;
        return 3 * (Math.log(Math.abs(a / b)) + Math.sqrt(inside));
    }
}