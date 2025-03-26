import java.util.*;
import java.util.Map;

public class StringComparator implements Comparator<String> {
    private Map<String, Integer> hits;

    public StringComparator(Map<String, Integer> hits) {
        this.hits = hits;
    }

    public int compare(String s1, String s2) {
        int hits1 = hits.get(s1);
        int hits2 = hits.get(s2);

        if (hits1 > hits2) {
            return -1;
        } else if (hits1 < hits2) {
            return 1;
        } else {
            return s1.compareTo(s2);
        }
    }
}