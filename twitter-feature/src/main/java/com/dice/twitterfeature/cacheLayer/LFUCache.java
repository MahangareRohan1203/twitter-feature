package com.dice.twitterfeature.cacheLayer;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public Object get(String key) {
        if (!keyToVal.containsKey(key))
            return null;

        final int freq = keyToFreq.get(key);
        freqToLRUKeys.get(freq).remove(key);
        if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
            freqToLRUKeys.remove(freq);
            ++minFreq;
        }

        // Increase key's freq by 1
        // Add this key to next freq's list
        putFreq(key, freq + 1);
        return keyToVal.get(key);
    }

    public void put(String key, Object value) {
        if (capacity == 0)
            return;
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key); // Update key's count
            return;
        }

        if (keyToVal.size() == capacity) {
            // Evict an LRU key from `minFreq` list.
            final String keyToEvict = freqToLRUKeys.get(minFreq).iterator().next();
            freqToLRUKeys.get(minFreq).remove(keyToEvict);
            keyToVal.remove(keyToEvict);
        }

        minFreq = 1;
        putFreq(key, minFreq);    // Add new key and freq
        keyToVal.put(key, value); // Add new key and value
    }

    private int capacity;
    private int minFreq = 0;
    private Map<String, Object> keyToVal = new HashMap<>();
    private Map<String, Integer> keyToFreq = new HashMap<>();
    private Map<Integer, LinkedHashSet<String>> freqToLRUKeys = new HashMap<>();

    private void putFreq(String key, int freq) {
        keyToFreq.put(key, freq);
        freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>());
        freqToLRUKeys.get(freq).add(key);
    }
}