import java.util.*;

class PrimesGenerator implements Iterable<Integer> {
    private final int N;

    public PrimesGenerator(int N) {
        this.N = N;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int count = 0;
            private int current = 2;

            @Override
            public boolean hasNext() {
                return count < N;
            }

            @Override
            public Integer next() {
                while (!isPrime(current)) {
                    current++;
                }
                count++;
                return current++;
            }
        };
    }
}

public class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10; // Количество простых чисел
        PrimesGenerator generator = new PrimesGenerator(N);

        List<Integer> primes = new ArrayList<>();
        for (int prime : generator) {
            primes.add(prime);
        }

        System.out.println("Первые N простых чисел: " + primes);
        Collections.reverse(primes);
        System.out.println("Первые N простых чисел в обратном порядке: " + primes);
    }
}
