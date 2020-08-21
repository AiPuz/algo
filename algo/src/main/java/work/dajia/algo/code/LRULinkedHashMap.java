import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private Integer capacity;
    private static final long serialVersionUid = 1L;

    LRULinkedHashMap(Integer capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.capacity;
    }

    public static void main(String[] args) {
        LRULinkedHashMap<Integer, Integer> lru = new LRULinkedHashMap(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println(lru.toString());
        lru.put(4, 4);
        System.out.println(lru.toString());
        lru.get(4);
        lru.get(3);
        System.out.println(lru.toString());
        lru.put(5, 5);
        System.out.println(lru.toString());
    }
}
