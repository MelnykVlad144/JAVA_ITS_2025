import java.util.Arrays;

public class Task67MergeAlternating {

    /**
     * Формує масив C(2*n), елементами якого є елементи масивів A(n) та B(n),
     * записані через один (a1, b1, a2, b2, ...).
     *
     * @param arrayA Перший масив (n елементів).
     * @param arrayB Другий масив (n елементів).
     * @return Новий масив C(2*n).
     * @throws NullPointerException якщо будь-який з масивів є null.
     * @throws IllegalArgumentException якщо масиви мають різну довжину.
     */
    public static int[] mergeArraysAlternating(int[] arrayA, int[] arrayB) {
        // Перевірка аргументів 
        if (arrayA == null || arrayB == null) {
            throw new NullPointerException("Обидва масиви не можуть бути null.");
        }
        if (arrayA.length != arrayB.length) {
            throw new IllegalArgumentException("Масиви A і B повинні мати однакову довжину (n).");
        }

        int n = arrayA.length;
        int[] arrayC = new int[2 * n];

        // Тут використовується цикл 'for', оскільки він забезпечує прямий доступ
        // до індексів обох вихідних масивів і нового масиву C.
        for (int i = 0; i < n; i++) {
            arrayC[2 * i] = arrayA[i];     // На парні індекси C записуємо елементи A
            arrayC[2 * i + 1] = arrayB[i]; // На непарні індекси C записуємо елементи B
        }

        return arrayC;
    }

    // Точка входу для тестування [cite: 11]
    public static void main(String[] agrs) {
        System.out.println("\n--- Тестування Завдання 67: Об'єднання через один ---");

        // 1. Дозволена комбінація: Звичайні масиви однакової довжини
        int[] A1 = {1, 3, 5};
        int[] B1 = {2, 4, 6};
        System.out.print("A: " + Arrays.toString(A1) + ", B: " + Arrays.toString(B1) + ". ");
        try {
            int[] result = mergeArraysAlternating(A1, B1);
            System.out.println("C: " + Arrays.toString(result) + " (Очікується [1, 2, 3, 4, 5, 6])");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 2. Дозволена комбінація: Порожні масиви
        int[] A2 = {};
        int[] B2 = {};
        System.out.print("A: " + Arrays.toString(A2) + ", B: " + Arrays.toString(B2) + ". ");
        try {
            int[] result = mergeArraysAlternating(A2, B2);
            System.out.println("C: " + Arrays.toString(result) + " (Очікується [])");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 3. Заборонена комбінація: Масиви різної довжини [cite: 12, 13]
        int[] A3 = {1, 2};
        int[] B3 = {3};
        System.out.print("A: " + Arrays.toString(A3) + ", B: " + Arrays.toString(B3) + ". ");
        try {
            int[] result = mergeArraysAlternating(A3, B3);
            System.out.println("C: " + Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println("Очікувана помилка (IllegalArgumentException): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неочікувана помилка: " + e.getMessage());
        }

        // 4. Заборонена комбінація: Один масив null [cite: 12, 13]
        System.out.print("A: [1], B: null. ");
        try {
            int[] result = mergeArraysAlternating(new int[]{1}, null);
            System.out.println("C: " + Arrays.toString(result));
        } catch (NullPointerException e) {
            System.out.println("Очікувана помилка (NullPointerException): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неочікувана помилка: " + e.getMessage());
        }
    }
}