public class Task37SumIndexMultipleOfThree {

    /**
     * Знаходить суму елементів масиву, у яких індекс кратний 3 (0, 3, 6, ...).
     * Обов'язково використовує цикл 'for-each' із допоміжною змінною індексу.
     *
     * @param array Масив цілих чисел.
     * @return Сума елементів.
     * @throws NullPointerException якщо масив є null.
     */
    public static long sumElementsAtIndexMultipleOfThree(int[] array) {
        // Перевірка аргументів
        if (array == null) {
            throw new NullPointerException("Масив не може бути null.");
        }

        long sum = 0;
        int index = 0;
        // Використання циклу 'for-each'
        for (int element : array) {
            if (index % 3 == 0) {
                sum += element;
            }
            index++;
        }
        return sum;
    }

    // Точка входу для тестування [cite: 11]
    public static void main(String[] agrs) {
        System.out.println("\n--- Тестування Завдання 37: Сума елементів, індекс кратний 3 ---");

        // 1. Дозволена комбінація: Звичайний масив (Індекси: 0, 1, 2, 3, 4, 5, 6)
        // Елементи, що додаються: 1 (index 0) + 4 (index 3) + 7 (index 6) = 12
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("Масив: [1, 2, 3, 4, 5, 6, 7]. ");
        try {
            long result = sumElementsAtIndexMultipleOfThree(arr1);
            System.out.println("Сума: " + result + " (Очікується 12)");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 2. Дозволена комбінація: Порожній масив
        int[] arr2 = {};
        System.out.print("Масив: []. ");
        try {
            long result = sumElementsAtIndexMultipleOfThree(arr2);
            System.out.println("Сума: " + result + " (Очікується 0)");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 3. Заборонена комбінація: null-масив [cite: 12, 13]
        System.out.print("Масив: null. ");
        try {
            long result = sumElementsAtIndexMultipleOfThree(null);
            System.out.println("Сума: " + result);
        } catch (NullPointerException e) {
            System.out.println("Очікувана помилка (NullPointerException): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неочікувана помилка: " + e.getMessage());
        }
    }
}