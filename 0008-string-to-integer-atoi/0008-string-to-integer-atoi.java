class Solution {
    public int myAtoi(String s) {
        int res = 0;
        s = s.trim();
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i == 0) {
                if (ch == '-' && sign == 1) {
                    sign = -1;
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
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + num;
        }
        return res * sign;
    }
}