import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Time-based Key-Value Store.
 *
 * Supports storing multiple values for the same key at different timestamps
 * and retrieving the value for a key at a given timestamp.
 */
class TimeMap {

    // Maps each key to a TreeMap of timestamp -> value
    private Map<String, TreeMap<Integer, String>> m;

    /**
     * Initializes the TimeMap data structure.
     */
    public TimeMap() {
        m = new HashMap<>();
    }

    /**
     * Stores the key with the given value at the given timestamp.
     *
     * @param key       The key to store
     * @param value     The value associated with the key
     * @param timestamp The time at which the value is stored
     */
    public void set(String key, String value, int timestamp) {

        // If the key does not exist, create a new TreeMap for it
        if (!m.containsKey(key)) {
            m.put(key, new TreeMap<>());
        }

        // Insert or update the value for the given timestamp
        m.get(key).put(timestamp, value);
    }

    /**
     * Retrieves the value associated with the largest timestamp
     * less than or equal to the given timestamp.
     *
     * @param key       The key to retrieve
     * @param timestamp The timestamp constraint
     * @return The stored value, or empty string if none exists
     */
    public String get(String key, int timestamp) {

        // If key does not exist, return empty string
        if (!m.containsKey(key)) {
            return "";
        }

        // Get the TreeMap of timestamps for this key
        TreeMap<Integer, String> timestamps = m.get(key);

        // Find the largest timestamp <= given timestamp
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);

        // If no such timestamp exists, return empty string
        if (entry == null) {
            return "";
        }

        // Return the corresponding value
        return entry.getValue();
    }
}

/*
Time Complexity:
- set(): O(log n), where n is the number of timestamps for the given key
- get(): O(log n), due to TreeMap floorEntry operation

Space Complexity:
- O(k * n), where k is the number of unique keys
  and n is the number of timestamps stored per key
*/