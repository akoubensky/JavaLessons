import java.util.Arrays;

public class TaskPermute {
//    написать функцию, которая получает ссылку на массив.
//    Массив из целых числе типа int. Функция переставляет элементы в массиве,
//    таким образом, чтобы в начале шли четные, а за ними нечетные.
//    С сохранением исходного порядка.

    /**
     * Функция переворачивает участок массива в диапазоне индексов от from до to.
     * Как обычно, в диапазонах первый индекс - включается, второй - исключается.
     * @param arr   Массив
     * @param from  Индекс начала диапазона
     * @param to    Индекс конца диапазона
     */
    private static void reverse(int[] arr, int from, int to) {
        for (int i = 0; i < (to - from) / 2; i++) {
            int element = arr[from + i];
            arr[from + i] = arr[to - i - 1];
            arr[to - i - 1] = element;
        }
    }

    /**
     * Функция меняет местами участки массива от low до mid и от mid до high.
     * Как обычно, в диапазонах первый индекс - включается, второй - исключается.
     * @param arr   Исходный массив
     * @param low   Начало первого участка
     * @param mid   Начало второго участка (и конец первого)
     * @param high  Конец второго участка
     */
    private static void sections(int[] arr, int low, int mid, int high) {
        reverse(arr, low, mid);
        reverse(arr, mid, high);
        reverse(arr, low, high);
    }

    /**
     * Решает задачу с перестановками элементов
     * @param arr   Массив, в котором функция переставляет элементы
     */
    private static void permute(int[] arr) {
        int length = arr.length;
        int odd = 0;
        // Находим первый нечетный элемент, если он есть
        while (odd < length && (arr[odd] & 1) == 0) odd++;
        if (odd == length) return;
        do {
            // Находим первый четный элемент за нечетными, если он есть
            int even = odd+1;
            while (even < length && (arr[even] & 1) == 1) even++;
            // Четный элемент не найден? завершаеи работу
            if (even == length) return;
            // Находим следующий нечетный элемент вслед за четными
            int odd1 = even + 1;
            while (odd1 < length && (arr[odd1] & 1) == 0) odd1++;
            // Теперь у нас есть два фрагмента массива, которые надо переставить местами:
            // Нечетные элементы от odd до even и четные - от even до odd1
            // Переставляем местами четные и нечетные
            sections(arr, odd, even, odd1);
            odd = odd1;
        } while (odd < length);
    }

    /**
     * Тестирование
     * @param args  Не используется
     */
    public static void main(String[] args) {
        int[] oddsOnly = { 1, 3, 5, 7, 9 };
        int[] evensOnly = { 2, 4, 6, 8 };
        int[] correct = { 2, 4, 6, 1, 3, 5 };
        int[] incorrect = { 1, 3, 5, 2, 4, 6 };
        int[] evensFirst = { 2, 4, 3, 5, 6, 8, 7, 9 };
        int[] oddsFirst = {3, 5, 2, 4, 6, 7, 9, 8 };

        permute(oddsOnly);
        System.out.println(Arrays.toString(oddsOnly));
        permute(evensOnly);
        System.out.println(Arrays.toString(evensOnly));
        permute(correct);
        System.out.println(Arrays.toString(correct));
        permute(incorrect);
        System.out.println(Arrays.toString(incorrect));
        permute(evensFirst);
        System.out.println(Arrays.toString(evensFirst));
        permute(oddsFirst);
        System.out.println(Arrays.toString(oddsFirst));
    }
}
