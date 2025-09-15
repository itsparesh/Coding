class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numList = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }

        if (n > 0) {
            do {
                int factorial = factorial(n - 1);
                int index = k / factorial;
                if (k % factorial == 0) {
                    index -= 1;
                }
                str.append(numList.get(index));
                numList.remove(index);
                k = k - factorial * index;
                n = numList.size();
            } while (n > 0);
        }
        return str.toString();
    }

    private int factorial(int num) {
        int res = 1;
        for (int i = 2; i <= num; i++) {
            res *= i;
        }
        return res;
    }
}