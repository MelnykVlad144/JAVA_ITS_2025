public class Task07CountEven {

    /**
     * Знаходить кількість парних елементів у заданому масиві цілих чисел.
     * Обов'язково використовує класичний цикл 'for'.
     *
     * @param array Масив цілих чисел.
     * @return Кількість парних елементів.
     * @throws NullPointerException якщо масив є null.
     * @throws IllegalArgumentException якщо масив порожній (довжина 0).
     */
    public static int countEvenElements(int[] array) {
        // Перевірка аргументів
        if (array == null) {
            throw new NullPointerException("Масив не може бути null.");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім.");
        }

        int count = 0;
        // Використання циклу 'for'
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // Точка входу для тестування [cite: 11]
    public static void main(String[] agrs) {
        System.out.println("--- Тестування Завдання 7: Кількість парних ---");

        // 1. Дозволена комбінація: Звичайний масив
        int[] arr1 = {1, 2, 3, 4, 5, 6, 10};
        System.out.print("Масив: [1, 2, 3, 4, 5, 6, 10]. ");
        try {
            int result = countEvenElements(arr1);
            System.out.println("Кількість парних: " + result + " (Очікується 4)");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 2. Дозволена комбінація: Масив без парних
        int[] arr2 = {1, 3, 5, 7};
        System.out.print("Масив: [1, 3, 5, 7]. ");
        try {
            int result = countEvenElements(arr2);
            System.out.println("Кількість парних: " + result + " (Очікується 0)");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 3. Заборонена комбінація: null-масив [cite: 12, 13]
        System.out.print("Масив: null. ");
        try {
            int result = countEvenElements(null);
            System.out.println("Кількість парних: " + result);
        } catch (NullPointerException e) {
            System.out.println("Очікувана помилка (NullPointerException): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неочікувана помилка: " + e.getMessage());
        }

        // 4. Заборонена комбінація: порожній масив [cite: 12, 13]
        int[] arr4 = {};
        System.out.print("Масив: []. ");
        try {
            int result = countEvenElements(arr4);
            System.out.println("Кількість парних: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Очікувана помилка (IllegalArgumentException): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неочікувана помилка: " + e.getMessage());
        }
    }
}