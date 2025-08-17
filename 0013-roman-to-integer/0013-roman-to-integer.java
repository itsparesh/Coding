class Solution {
    public int romanToInt(String s) {
        int i = s.length() - 1;
        int res = 0;
        while (i >= 0) {
            char ch = s.charAt(i);
            boolean isLess = false;
            switch (ch) {
                case 'I':
                    res += 1;
                    i--;
                    break;
                case 'V':
                    if (i - 1 >= 0) {
                        char chNext = s.charAt(i - 1);
                        if (chNext == 'I') {
                            isLess = true;
                            res += 4;
                            i--;
                        }
                    }
                    if (!isLess) {
                        res += 5;
                    }
                    i--;
                    break;
                case 'X':
                    if (i - 1 >= 0) {
                        char chNext = s.charAt(i - 1);
                        if (chNext == 'I') {
                            isLess = true;
                            res += 9;
                            i--;
                        }
                    }
                    if (!isLess) {
                        res += 10;
                    }
                    i--;
                    break;
                case 'L':
                    if (i - 1 >= 0) {
                        char chNext = s.charAt(i - 1);
                        if (chNext == 'X') {
                            isLess = true;
                            res += 40;
                            i--;
                        }
                    }
                    if (!isLess) {
                        res += 50;
                    }
                    i--;
                    break;
                case 'C':
                    if (i - 1 >= 0) {
                        char chNext = s.charAt(i - 1);
                        if (chNext == 'X') {
                            isLess = true;
                            res += 90;
                            i--;
                        }
                    }
                    if (!isLess) {
                        res += 100;
                    }
                    i--;
                    break;
                case 'D':
                    if (i - 1 >= 0) {
                        char chNext = s.charAt(i - 1);
                        if (chNext == 'C') {
                            isLess = true;
                            res += 400;
                            i--;
                        }
                    }
                    if (!isLess) {
                        res += 500;
                    }
                    i--;
                    break;
                case 'M':
                    if (i - 1 >= 0) {
                        char chNext = s.charAt(i - 1);
                        if (chNext == 'C') {
                            isLess = true;
                            res += 900;
                            i--;
                        }
                    }
                    if (!isLess) {
                        res += 1000;
                    }
                    i--;
                    break;
            }
        }
        return res;
    }
}