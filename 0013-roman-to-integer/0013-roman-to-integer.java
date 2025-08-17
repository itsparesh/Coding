class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (i + 1 < len && value(ch) < value(s.charAt(i + 1))) {
                res -= value(ch);
            } else {
                res += value(ch);
            }
        }
        return res;
    }

    private static int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:  return 0;
        }
    }
}