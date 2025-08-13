class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, len = s.length();
        if (len < 2) return len;
        int max = 0;
        HashMap<Character, Integer> charMap = new LinkedHashMap<>();
        for (int j = 0; j < len; j++) {
            char ch = s.charAt(j);
            if (charMap.containsKey(ch)) {
                i = Math.max(i, charMap.get(ch) + 1);
            }
            charMap.put(ch, j);
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}