import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task08CountNumbers {

    /**
     * Підраховує кількість числових токенів (складаються лише з цифр) у реченні.
     *
     * @param sentence Вхідний рядок (речення).
     * @return Кількість чисел у реченні.
     * @throws NullPointerException якщо вхідний рядок є null.
     */
    public static int countNumbers(String sentence) {
        // Перевірка аргументів
        if (sentence == null) {
            throw new NullPointerException("Вхідний рядок не може бути null.");
        }

        int count = 0;
        // Регулярний вираз для пошуку одного або більше символів-цифр (\\d+), 
        // які не мають літер по обидва боки (це відсіює комбінації літер та цифр).
        // Використовуємо межу слова (\\b), щоб відокремити токени.
        // Це спрощений підхід, який вважає токеном "число", якщо він оточений
        // не-буквено-цифровими символами (пробілами, роздільниками тощо).

        // Регулярний вираз для пошуку послідовності цифр (\\d+)
        // Оскільки завдання вимагає знайти саме "цілі числа (складаються з цифр 0-9)",
        // потрібно знайти токени, які складаються ТІЛЬКИ з цифр.

        // Найпростіший спосіб: розділити рядок по не-літерно-цифровим символам, 
        // а потім перевірити кожен токен, чи він складається лише з цифр.
        String[] tokens = sentence.split("[^a-zA-Z0-9]+");

        for (String token : tokens) {
            // Видаляємо пробіли з початку/кінця
            token = token.trim();

            // Якщо токен не порожній і складається ТІЛЬКИ з цифр
            if (!token.isEmpty() && token.matches("\\d+")) {
                count++;
            }
        }

        return count;
    }

    // Точка входу для тестування
    public static void main(String[] agrs) {
        System.out.println("\n--- Тестування Завдання 8: Підрахунок чисел ---");

        // 1. Дозволена комбінація (Приклад з таблиці: 3 та 4)
        String s1 = "The user with the nickname koala757677 this month wrote 3 times more comments than the user with the nickname croco181dile920 4 months ago";
        System.out.print("Речення: \"" + s1 + "\". ");
        try {
            int result = countNumbers(s1);
            System.out.println("Кількість чисел: " + result + " (Очікується 2: 3, 4)");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 2. Дозволена комбінація: Тільки числа та роздільники
        String s2 = "1 2 3 456.";
        System.out.print("Речення: \"" + s2 + "\". ");
        try {
            int result = countNumbers(s2);
            System.out.println("Кількість чисел: " + result + " (Очікується 4)");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 3. Дозволена комбінація: Числа на початку та кінці
        String s3 = "10 cats and 20 dogs.";
        System.out.print("Речення: \"" + s3 + "\". ");
        try {
            int result = countNumbers(s3);
            System.out.println("Кількість чисел: " + result + " (Очікується 2)");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 4. Заборонена комбінація: null-рядок
        System.out.print("Речення: null. ");
        try {
            int result = countNumbers(null);
            System.out.println("Кількість чисел: " + result);
        } catch (NullPointerException e) {
            System.out.println("Очікувана помилка (NullPointerException): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неочікувана помилка: " + e.getMessage());
        }
    }
}