package HW_0307;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {9, 2, 5, 1, 7, 4, 8, 3, 6};
        System.out.println("Исходный массив:");
        printArray(array);

        mergeSort(array);

        System.out.println("Отсортированный массив:");
        printArray(array);
    }

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Базовый случай: если размер массива меньше 2, то он уже отсортирован
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Заполняем левый и правый подмассивы
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        // Рекурсивно сортируем левый и правый подмассивы
        mergeSort(left);
        mergeSort(right);

        // Объединяем отсортированные подмассивы
        merge(left, right, array);
    }

    public static void merge(int[] left, int[] right, int[] array) {
        int i = 0, j = 0, k = 0;

        // Сравниваем элементы левого и правого подмассивов и помещаем их в исходный массив в отсортированном порядке
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Копируем оставшиеся элементы из левого подмассива, если они есть
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Копируем оставшиеся элементы из правого подмассива, если они есть
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
