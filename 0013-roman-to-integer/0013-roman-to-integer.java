class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int i = s.length() - 1;

        while (i >= 0) {
            switch (s.charAt(i)) {
                case 'I':
                    res += 1;
                    i--;
                    break;

                case 'V':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                        res += 4;
                        i -= 2;
                    } else {
                        res += 5;
                        i--;
                    }
                    break;

                case 'X':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                        res += 9;
                        i -= 2;
                    } else {
                        res += 10;
                        i--;
                    }
                    break;

                case 'L':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                        res += 40;
                        i -= 2;
                    } else {
                        res += 50;
                        i--;
                    }
                    break;

                case 'C':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                        res += 90;
                        i -= 2;
                    } else {
                        res += 100;
                        i--;
                    }
                    break;

                case 'D':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                        res += 400;
                        i -= 2;
                    } else {
                        res += 500;
                        i--;
                    }
                    break;

                case 'M':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                        res += 900;
                        i -= 2;
                    } else {
                        res += 1000;
                        i--;
                    }
                    break;
            }
        }

        return res;
    }
}
