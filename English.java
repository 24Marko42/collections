import java.util.*;

public class English {
    public static void main(String[] args) {
        String text = "This is a simple example. This example is simple.";
        String[] words = text.toLowerCase().split("\\W+"); // Разбиваем строку на слова, игнорируя знаки препинания.

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Частота встречаемости слов: " + wordCount);
    }
}
