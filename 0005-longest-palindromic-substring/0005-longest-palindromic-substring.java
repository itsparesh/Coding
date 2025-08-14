class Solution {
    public String longestPalindrome(String s) {
        String result = new String();

        for (int i = 0; i < s.length(); i++) {
            String odd = findPalindrome(s, i, i);
            String even = findPalindrome(s, i, i + 1); 

            if (odd.length() > result.length()) {
                result = odd;
            }
            if (even.length() > result.length()) {
                result = even;
            }
        }
        
        return result;
    }

    private String findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}