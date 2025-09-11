class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        if (n == 0) return 1;
        if (x == 0 || exp > Integer.MAX_VALUE || exp < Integer.MIN_VALUE) return 0;
        double res = 1.0;
        if (exp < 0) {
            x = 1/x;
            exp = -exp;
        }

        while (exp > 0) {
            if (exp % 2 == 1) {
                res *= x;
            }
            x *= x;
            exp /= 2;
        }

        return res;
    }
}