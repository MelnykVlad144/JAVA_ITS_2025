package Pz2;

public class Task2 {
    public static void main(String[] args) {
        printResult(-2, 3, 5);
        printResult(-1, 2, 10);
        printResult(2, 3, 5);   // помилка (t > 0)
        printResult(-2, 3, 30); // помилка (k > 25)
    }

    static void printResult(double t, double s, int k) {
        System.out.print("t = " + t + ", s = " + s + ", k = " + k + " result: ");
        try {
            System.out.println(sumSeries(t, s, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }

    public static double sumSeries(double t, double s, int k) {
        if (k <= 2 || k > 25)
            throw new IllegalArgumentException("k must be in range 3..25");
        if (t >= 0)
            throw new IllegalArgumentException("t must be < 0 (since ln(-t*i) requires positive argument)");

        double sum = 0;
        for (int i = 1; i <= k; i++) {
            double arg = -t * i;
            if (arg <= 0)
                throw new IllegalArgumentException("Invalid ln argument: -t*i = " + arg);

            double term = Math.log(arg) * Math.cos(Math.sqrt(s * (1.0 / (i * i))));
            sum += term;
        }
        return sum;
    }
}
