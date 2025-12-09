package Pz2;

public class Task14 {
    public static void main(String[] args) {
        printResult(0.01);
        printResult(0.0001);
        printResult(-0.5); // помилка (ε < 0)
    }

    static void printResult(double eps) {
        System.out.print("ε = " + eps + " result: ");
        try {
            System.out.println(sumInfinite(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }

    public static double sumInfinite(double eps) {
        if (eps <= 0)
            throw new IllegalArgumentException("ε must be > 0");

        double sum = 0;
        int i = 0;
        double term;

        do {
            term = Math.pow(-2, i) / (factorial(i) * (i + 1));
            sum += term;
            i++;
        } while (Math.abs(term) >= eps);

        return sum;
    }

    // Допоміжний метод для обчислення факторіала
    public static double factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be >= 0");
        double f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
