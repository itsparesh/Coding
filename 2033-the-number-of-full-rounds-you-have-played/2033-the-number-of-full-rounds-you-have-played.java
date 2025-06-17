class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int inMin = timeToMinutes(loginTime);
        int outMin = timeToMinutes(logoutTime);

        if (outMin < inMin) {
            outMin += 24 * 60;
        }

        inMin = ((inMin + 14) / 15) * 15;
        outMin = (outMin / 15) * 15;
        return Math.max(0, (outMin - inMin) / 15);
    }

    private int timeToMinutes(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));
        return h * 60 + m;
    }
}