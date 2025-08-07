class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int maxLen = 0;
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                maxLen = Math.max(maxLen, set.size());
                Iterator<Character> iterator = set.iterator();
                while (iterator.hasNext()) {
                    char first = iterator.next();
                    iterator.remove();
                    if (first == ch) break;
                }
            }
            set.add(ch);
        }
        return Math.max(maxLen, set.size());
    }
}