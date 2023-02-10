import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;

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
        System.out.println("Number of words in the text: " + words.length);

        // Part 2: Get the top 10 most frequently mentioned words
        Map<String, Long> wordFrequency = Stream.of(words)
                .map(word -> word.toLowerCase())
                .collect(HashMap::new,
                        (m, word) -> m.put(word, m.getOrDefault(word, 0L) + 1L),
                        HashMap::putAll);

        wordFrequency.entrySet().stream()
                .sorted((a, b) -> {
                    int compare = b.getValue().compareTo(a.getValue());
                    if (compare == 0) {
                        return a.getKey().compareTo(b.getKey());
                    }
                    return compare;
                })
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

}