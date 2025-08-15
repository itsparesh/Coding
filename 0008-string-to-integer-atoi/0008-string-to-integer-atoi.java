class Solution {
    public int myAtoi(String s) {
        int res = 0;
        StringBuilder interim = new StringBuilder();
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
                if (ch == '+') {
                    continue;
                }
                if (ch != '-' && ch != '+' && (ch < '0' || ch > '9')) {
                    break;
                }
            }
            if (ch < '0' || ch > '9') {
                break;
            }
            interim.append(ch);
        }

        for (int i = 0; i < interim.length(); i++) {
            int num = Integer.parseInt("" + interim.charAt(i));
            if (res > (Integer.MAX_VALUE - num) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = num + res * 10; 
        }
        return isNegative? res * -1: res;
    }
}