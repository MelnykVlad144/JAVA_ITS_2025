import java.util.Objects;

public class Task01IntToHexString {

    /**
     * Перетворює значення int у об'єкт String, що представляє собою число
     * у шістнадцятковій системі числення.
     *
     * @param i Ціле число для перетворення.
     * @return Шістнадцяткове представлення числа у вигляді рядка.
     */
    public static String intToHexString(int i) {
        // Оскільки вхідний аргумент є примітивним типом (int), перевірка на NullPointerException
        // або IllegalArgumentException для самого значення i зазвичай не потрібна,
        // якщо не вимагається обмеження діапазону. Використовуємо вбудований метод.
        return Integer.toHexString(i).toUpperCase();
    }

    // Точка входу для тестування
    public static void main(String[] agrs) {
        System.out.println("--- Тестування Завдання 1: intToHexString ---");

        // 1. Дозволена комбінація: Позитивне число (Приклад з таблиці: 51966 -> CAFE)
        int i1 = 51966;
        System.out.print("Аргумент: " + i1 + ". ");
        try {
            String result = intToHexString(i1);
            System.out.println("Результат: \"" + result + "\" (Очікується \"CAFE\")");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 2. Дозволена комбінація: Мале число (10 -> A)
        int i2 = 10;
        System.out.print("Аргумент: " + i2 + ". ");
        try {
            String result = intToHexString(i2);
            System.out.println("Результат: \"" + result + "\" (Очікується \"A\")");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 3. Дозволена комбінація: Нуль (0 -> 0)
        int i3 = 0;
        System.out.print("Аргумент: " + i3 + ". ");
        try {
            String result = intToHexString(i3);
            System.out.println("Результат: \"" + result + "\" (Очікується \"0\")");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 4. Дозволена комбінація: Від'ємне число (Використовується доповнення до двох)
        int i4 = -1; // -1 -> FFFFFFFF
        System.out.print("Аргумент: " + i4 + ". ");
        try {
            String result = intToHexString(i4);
            System.out.println("Результат: \"" + result + "\" (Очікується \"FFFFFFFF\")");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}