import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SearchEngine {
    private String myURL;
    private Map<String, List<String>> myIndex;

    public SearchEngine(String url) {
        myURL = url;
        myIndex = new HashMap<String, List<String>>();
    }

    public String getURL() {
        return myURL;
    }

    public void add(String line) {
        Set<String> words = parseWords(line);

        for (String word : words) {
            List<String> list = new LinkedList<String>();

            if (myIndex.containsKey(word)) {
                list = myIndex.get(word);
            }

            list.add(line);
            myIndex.put(word, list);
        }
    }

    public PriorityQueue<String> getHits(String searchWord) {
        if (!myIndex.containsKey(searchWord)) {
            return new PriorityQueue<String>();
        }

        List<String> lines = myIndex.get(searchWord);
        Map<String, Integer> hitsCount = new TreeMap<String, Integer>();

        for (String line : lines) {
            int hits = 0;
            String[] words = line.split("\\W+");

            for (String word : words) {
                if (word.equalsIgnoreCase(searchWord)) {
                    hits++;
                }
            }

            hitsCount.put(line, hits);
        }

        StringComparator comparator = new StringComparator(hitsCount);

        PriorityQueue<String> hitsQueue = new PriorityQueue<String>(comparator);
        hitsQueue.addAll(hitsCount.keySet());

        return hitsQueue;
    }

    private Set<String> parseWords(String line) {
        String[] words = line.split("\\W+");
        Set<String> treeSet = new TreeSet<String>();

        for (String word : words) {
            if (word.length() > 0) {
                treeSet.add(word.toLowerCase());
            }
        }

        return treeSet;
    }
}