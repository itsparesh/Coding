class Solution {
    public String countAndSay(int n) {
        String res = "1";
        if (n == 1) return res;
        for (int i = 1; i < n; i++) {
           res = count(res);
        }
        return res;
    }

    private String count(String num) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        int len = num.length();
        if (len > 1) {
            char ch = '1';
            char chNext = '1';
            for (int i = 0; i < num.length() && i + 1 < num.length(); i++) {
                ch = num.charAt(i);
                chNext = num.charAt(i + 1);
                if (ch == chNext) {
                    count++;
                } else {
                    stringBuilder.append(count);
                    stringBuilder.append(ch);
                    count = 1;
                }
            }
            if (count >= 1) {
                stringBuilder.append(count);
                stringBuilder.append(chNext);
            }
        } else {
            stringBuilder.append(1);
            stringBuilder.append(1);
        }    
        return stringBuilder.toString();
    }
}