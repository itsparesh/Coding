class Solution {
    public int lengthOfLongestSubstring(String s) {
        int front = 0, max = 0;
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (indexMap.containsKey(ch)) {
                front = Math.max(front, indexMap.get(ch) + 1);
            }
            indexMap.put(ch, end);
            max = Math.max(max, end - front + 1); 
        }
        return max;
    }
}