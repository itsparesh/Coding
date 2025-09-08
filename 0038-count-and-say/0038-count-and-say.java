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
        for (int i = 1; i < num.length(); i++) {
            char ch = num.charAt(i);
            char chPrev = num.charAt(i - 1);
            if (ch == chPrev) {
                count++;
            } else {
                stringBuilder.append(count).append(chPrev);
                count = 1;
            }
        }
        stringBuilder.append(count).append(num.charAt(num.length() - 1));
        return stringBuilder.toString();
    }
}