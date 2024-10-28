import java.util.*;

public class collectionsExample {
    public static void main(String[] args) {
        int N = 10; // Количество случайных чисел
        Random random = new Random(); // Экземпляр класса Random для создания случайных чисел

        // a) Создайте массив из N случайных чисел от 0 до 100.
        Integer[] massiv = new Integer[N];
        for (int i = 0; i < N; i++) {
            massiv[i] = random.nextInt(101); // Генерируем случайные числа от 0 до 100
        }
        System.out.println("a) Массив случайных чисел: " + Arrays.toString(massiv));

        // b) На основе массива создайте список List.
        List<Integer> list = new ArrayList<>(Arrays.asList(massiv));
        System.out.println("b) Список на основе массива: " + list);

        // c) Отсортируйте список по возрастанию.
        Collections.sort(list);
        System.out.println("c) Список отсортирован по возрастанию: " + list);

        // d) Отсортируйте список в обратном порядке.
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("d) Список отсортирован в обратном порядке: " + list);

        // e) Перемешайте список.
        Collections.shuffle(list);
        System.out.println("e) Перемешанный список: " + list);

        // f) Выполните циклический сдвиг на 1 элемент.
        Collections.rotate(list, 1);
        System.out.println("f) Список после циклического сдвига на 1 элемент: " + list);

        // g) Оставьте в списке только уникальные элементы.   
        List<Integer> uniqueElemets = new ArrayList<>(new HashSet<>(list));// Класс HashSet нужен для того, чтобы остались уникальные элементы
        list = new ArrayList<>(uniqueElemets);
        System.out.println("g) Список с уникальными элементами: " + list);

        // h) Оставьте в списке только дублирующиеся элементы.
        List<Integer> duplicates = new ArrayList<>();
        List<Integer> uniqueElemets2 = new ArrayList<>(new HashSet<>(list));
        for (int num : list) {
            if (!uniqueElemets2.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println("h) Список только с дублирующимися элементами: " + duplicates);

        // i) Из списка получите массив.
        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("i) Массив, полученный из списка: " + Arrays.toString(newArray));

        // j) Посчитайте количество вхождений каждого числа в массив и выведите на экран.
        Map<Integer, Integer> vhozdenia = new HashMap<>();
        for (int num : newArray) {
            vhozdenia.put(num, vhozdenia.getOrDefault(num, 0) + 1);
        }
        System.out.println("j) Количество вхождений каждого числа: " + vhozdenia);
    }
}
