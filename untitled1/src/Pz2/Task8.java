package Pz2;

public class Task8 {
    public static void main(String[] args) {
        printResult(2, 5, 3);  // t=2, n=5, l=3
        printResult(4, 6, 2);  // t=4, n=6, l=2
        printResult(-2, 5, 3); // помилка (t < 0)
        printResult(0, 5, 1);  // помилка (t = 0)
    }

    static void printResult(double t, int n, int l) {
        System.out.print("t = " + t + ", n = " + n + ", l = " + l + " result: ");
        try {
            System.out.println(calcFunction(t, n, l));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }

    public static double calcFunction(double t, int n, int l) {
        if (t <= 0)
            throw new IllegalArgumentException("t must be > 0");
        if (n <= 0)
            throw new IllegalArgumentException("n must be > 0");
        if (l <= 0)
            throw new IllegalArgumentException("l must be > 0");

        double sum = 0;

        for (int i = 1; i <= n; i++) {
            if (l % 2 == 1) {
                sum += l / t;
            } else {
                sum += l / Math.sqrt(t);
            }
        }

        return sum;
    }
}
