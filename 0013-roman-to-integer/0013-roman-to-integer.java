class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        int res = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (i + 1 < len && charMap.get(ch) < charMap.get(s.charAt(i + 1))) {
                res -= charMap.get(ch);
            } else {
                res += charMap.get(ch);
            }
        }
        return res;
    }
}