import java.util.Arrays;

public class Lab05Variant07 {

    /**
     * Метод сортування обміном (Bubble Sort) для short[] за зростанням.
     * @param array Масив для сортування.
     */
    public static void bubbleSort(short[] array) {
        int n = array.length;
        boolean swapped;
        // Зовнішній цикл проходить по всьому масиву, зменшуючи область сортування
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Внутрішній цикл проходить до вже відсортованої частини (n - i - 1)
            for (int j = 0; j < n - i - 1; j++) {
                // Якщо поточний елемент більший за наступний, міняємо їх місцями
                if (array[j] > array[j + 1]) {
                    // Обмін
                    short temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // Якщо обмінів не було, масив вже відсортований
            if (!swapped) break;
        }
    }

    /**
     * Метод сортування вибором (Selection Sort) для short[] за зростанням.
     * @param array Масив для сортування.
     */
    public static void selectionSort(short[] array) {
        int n = array.length;
        // Проходимо по всьому масиву
        for (int i = 0; i < n - 1; i++) {
            // Вважаємо, що поточний елемент (i) є мінімальним
            int minIndex = i;

            // Знаходимо індекс фактично мінімального елемента в невідсортованій частині
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Якщо мінімальний елемент не на поточному місці (i), міняємо їх місцями
            if (minIndex != i) {
                short temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // Тестовий масив
        short[] originalArray = {50, 10, 45, 80, 25, 5, 99};

        // --- 1. Тестування Bubble Sort ---
        short[] bubbleArr = Arrays.copyOf(originalArray, originalArray.length);
        System.out.println("--- Bubble Sort (short[], за зростанням) ---");
        System.out.println("Початковий: " + Arrays.toString(bubbleArr));
        bubbleSort(bubbleArr);
        System.out.println("Відсортований: " + Arrays.toString(bubbleArr));

        System.out.println("----------------------------------------------");

        // --- 2. Тестування Selection Sort ---
        short[] selectionArr = Arrays.copyOf(originalArray, originalArray.length);
        System.out.println("--- Selection Sort (short[], за зростанням) ---");
        System.out.println("Початковий: " + Arrays.toString(selectionArr));
        selectionSort(selectionArr);
        System.out.println("Відсортований: " + Arrays.toString(selectionArr));
    }
}