import java.util.*;

public class MapMap {
    public static <K, V> Map<V, K> invertMap(Map<K, V> map) { // <K, V> - дженерики, позволяющие работать с разными типами данных
        Map<V, K> invertedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("Alice", 30);
        originalMap.put("Bob", 25);
        originalMap.put("Charlie", 35);

        Map<Integer, String> invertedMap = invertMap(originalMap);
        System.out.println("Инвертированная Map: " + invertedMap);
    }
}