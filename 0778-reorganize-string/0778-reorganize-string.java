class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);            
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charMap.get(b) - charMap.get(a));
        maxHeap.addAll(charMap.keySet());   

        StringBuilder res = new StringBuilder();

        while (maxHeap.size() > 1) { 
            char ch1 = maxHeap.poll();
            char ch2 = maxHeap.poll();

            res.append(ch1);
            res.append(ch2);
            
            charMap.put(ch1, charMap.get(ch1) - 1);
            charMap.put(ch2, charMap.get(ch2) - 1);

            if (charMap.get(ch1) > 0) maxHeap.add(ch1);
            if (charMap.get(ch2) > 0) maxHeap.add(ch2);
        }

        if (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            if (charMap.get(ch) > 1) return "";
            res.append(ch);
        }

        return res.toString();
    }
}