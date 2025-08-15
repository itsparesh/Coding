class Solution {
    public int myAtoi(String s) {
        int res = 0;
        s = s.trim();
        boolean isNegative = false;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (i == 0) {
                if (ch == '-' && !isNegative) {
                    isNegative = true;
                    continue;
                }
                else if (ch == '+') {
                    continue;
                }
                
            }
            if (!Character.isDigit(ch)) {
                break;
            }
            int num = ch - '0';
            if (res > (Integer.MAX_VALUE - num) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = num + res * 10;
        }
        return isNegative? res * -1: res;
    }
}