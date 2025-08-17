class Solution {
    public int romanToInt(String s) {
        int[] values = new int[128];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int res = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (i + 1 < len && values[ch] < values[s.charAt(i + 1)]) {
                res -= values[ch];
            } else {
                res += values[ch];
            }
        }
        return res;
    }
}