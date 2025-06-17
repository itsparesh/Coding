class LRUCache {
    
    LinkedHashMap<Integer, Integer> map;
    int totalCap = 0;

    public LRUCache(int capacity) {
    
        map = new LinkedHashMap<>(); 
        totalCap = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if (map.containsKey(key)) {
            map.remove(key);
        } 
        
        map.put(key, value);
        
        if (map.size() > totalCap)
         {
            Integer entry = map.keySet().iterator().next();
            map.remove(entry);
         }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */