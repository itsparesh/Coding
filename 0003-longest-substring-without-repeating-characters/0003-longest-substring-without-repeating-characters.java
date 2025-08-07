class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        int maxLen = 0;
        Set<Character> set = new LinkedHashSet<>();
        set.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
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