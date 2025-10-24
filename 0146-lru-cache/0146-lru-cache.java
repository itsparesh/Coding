class LRUCache {

    private int totalCapacity = 0;
    private LinkedHashMap<Integer, Integer> cacheMap;

    public LRUCache(int capacity) {
        totalCapacity = capacity;
        cacheMap = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            int value = cacheMap.get(key);
            cacheMap.remove(key);
            cacheMap.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            cacheMap.remove(key);
        }

        cacheMap.put(key, value);

        if (cacheMap.size() > totalCapacity) {
            int leastKey = cacheMap.keySet().iterator().next();
            cacheMap.remove(leastKey);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */