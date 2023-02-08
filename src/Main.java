import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your text without empty lines and paragraphs and press twice \"Enter\": ");

        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            sb.append(line).append(" ");
        }
        String input = sb.toString().trim();
        String[] words = input.split("\\s+");

        // Part 1: Count the number of words in the text
        int wordCount = words.length;
        System.out.println("Number of words in the text: " + wordCount);

        // Part 2: Get the top 10 most frequently mentioned words
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFrequency.entrySet());
        Collections.sort(entries, (a, b) -> {
            int compare = b.getValue().compareTo(a.getValue());
            if (compare == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return compare;
        });

        System.out.println("Top 10 most frequently mentioned words: ");
        for (int i = 0; i < 10 && i < entries.size(); i++) {
            System.out.println(entries.get(i).getKey() + ": " + entries.get(i).getValue());
        }
    }
}
