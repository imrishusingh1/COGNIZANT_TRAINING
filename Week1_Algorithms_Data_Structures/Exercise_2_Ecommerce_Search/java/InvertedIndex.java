import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvertedIndex {
    private final Map<String, Map<String, Integer>> index = new HashMap<>();
    private final Map<String, String> products = new HashMap<>();
    private final Map<String, Integer> df = new HashMap<>();
    private int docCount = 0;

    private static final Pattern TOKEN = Pattern.compile("\\w+");

    private List<String> tokenize(String text) {
        List<String> out = new ArrayList<>();
        if (text == null) return out;
        Matcher m = TOKEN.matcher(text.toLowerCase());
        while (m.find()) out.add(m.group());
        return out;
    }

    public void addDocument(String docId, String text) {
        List<String> terms = tokenize(text);
        Map<String, Integer> tf = new HashMap<>();
        for (String t : terms) tf.put(t, tf.getOrDefault(t, 0) + 1);
        for (Map.Entry<String, Integer> e : tf.entrySet()) {
            index.computeIfAbsent(e.getKey(), k -> new HashMap<>()).put(docId, e.getValue());
        }
        products.put(docId, text);
        docCount++;
    }

    public void buildFromProducts(List<Product> productList) {
        for (Product p : productList) addDocument(p.id, p.combined());
        for (Map.Entry<String, Map<String, Integer>> e : index.entrySet()) df.put(e.getKey(), e.getValue().size());
    }

    public List<Result> search(String query, int topK) {
        List<String> terms = tokenize(query);
        Map<String, Double> scores = new HashMap<>();
        double N = Math.max(1, docCount);
        for (String term : terms) {
            Map<String, Integer> postings = index.get(term);
            if (postings == null) continue;
            double idf = Math.log((N + 1) / (1 + df.getOrDefault(term, 0)));
            for (Map.Entry<String, Integer> e : postings.entrySet()) {
                scores.put(e.getKey(), scores.getOrDefault(e.getKey(), 0.0) + e.getValue() * idf);
            }
        }
        List<Result> results = new ArrayList<>();
        for (Map.Entry<String, Double> e : scores.entrySet()) results.add(new Result(e.getKey(), products.get(e.getKey()), e.getValue()));
        results.sort((a, b) -> Double.compare(b.score, a.score));
        if (results.size() > topK) return results.subList(0, topK);
        return results;
    }

    public static class Result {
        public final String id;
        public final String text;
        public final double score;

        public Result(String id, String text, double score) {
            this.id = id;
            this.text = text;
            this.score = score;
        }
    }
}
