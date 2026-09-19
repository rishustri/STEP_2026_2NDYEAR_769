import java.util.*;

class WordFrequency {
    public static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>(Arrays.asList(
            "the","was","and","a","is","of","in"
        ));

        // Normalize text
        feedback = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = feedback.split("\\s+");

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (!stopWords.contains(word)) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        // Sort by frequency (descending)
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
    }
}
