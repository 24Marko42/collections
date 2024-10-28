import java.util.*;

// Класс PrimesGenerator реализует интерфейс Iterable<Integer>,
// что позволяет итерироваться по сгенерированным простым числам с помощью цикла for-each.
class PrimesGenerator implements Iterable<Integer> {
    private final int N; // Поле для хранения количества простых чисел, которые нужно сгенерировать.

    // Конструктор принимает целое число N, которое определяет количество простых чисел, которые мы хотим сгенерировать.
    public PrimesGenerator(int N) {
        this.N = N;
    }

    // Метод isPrime определяет, является ли число простым.
    private boolean isPrime(int num) {
        // Числа меньше 2 не являются простыми.
        if (num < 2) return false;
        // Проверяем делимость числа на все целые числа от 2 до квадратного корня числа.
        // Если хотя бы одно число делит num без остатка, то оно не является простым.
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        // Если число прошло все проверки, оно является простым.
        return true;
    }

    // Метод iterator возвращает новый итератор для перебора простых чисел.
    @Override
    public Iterator<Integer> iterator() {
        // Создаем и возвращаем анонимный класс, реализующий интерфейс Iterator<Integer>.
        return new Iterator<Integer>() {
            private int count = 0; // Счетчик количества уже найденных простых чисел.
            private int current = 2; // Начинаем с 2, так как это первое простое число.

            // Метод hasNext проверяет, есть ли еще простые числа для генерации.
            @Override
            public boolean hasNext() {
                // Возвращает true, если количество найденных простых чисел меньше заданного N.
                return count < N;
            }

            // Метод next возвращает следующее простое число.
            @Override
            public Integer next() {
                // Находим следующее простое число, увеличивая current, пока не найдем простое.
                while (!isPrime(current)) {
                    current++; // Увеличиваем current, пока не найдем простое число.
                }
                // Увеличиваем счетчик найденных простых чисел.
                count++;
                // Возвращаем текущее простое число и увеличиваем current для следующей проверки.
                return current++;
            }
        };
    }
}

// Класс PrimesGeneratorTest для тестирования генератора простых чисел.
public class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10; // Указываем количество простых чисел, которые хотим сгенерировать.
        PrimesGenerator generator = new PrimesGenerator(N); // Создаем экземпляр генератора с N.

        // Создаем список для хранения сгенерированных простых чисел.
        List<Integer> primes = new ArrayList<>();
        // Используем цикл for-each для перебора простых чисел из генератора.
        // Благодаря реализации Iterable в PrimesGenerator, мы можем использовать этот цикл.
        for (int prime : generator) {
            primes.add(prime); // Добавляем каждое найденное простое число в список.
        }

        // Выводим на экран сгенерированные простые числа в прямом порядке.
        System.out.println("Первые N простых чисел: " + primes);

        // Используем метод Collections.reverse для реверсирования списка простых чисел.
        Collections.reverse(primes);
        // Выводим на экран сгенерированные простые числа в обратном порядке.
        System.out.println("Первые N простых чисел в обратном порядке: " + primes);
    }
}
