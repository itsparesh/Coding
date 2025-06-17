class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        String[] logInTime = loginTime.split(":");
        String[] logOutTime = logoutTime.split(":");
        int inHour = Integer.parseInt(logInTime[0]);
        int inMin = Integer.parseInt(logInTime[1]);
        int outHour = Integer.parseInt(logOutTime[0]);
        int outMin = Integer.parseInt(logOutTime[1]);

        if (outHour > inHour || (outHour == inHour && outMin >= inMin)) {
            outMin = outHour * 60 + outMin;
            inMin = inHour * 60 + inMin;
        } else {
            inMin = inHour * 60 + inMin;
            outMin = outHour * 60 + outMin + 24 * 60;
        }

        inMin = ((inMin + 14) / 15) * 15;
        outMin = (outMin / 15) * 15;
        return Math.max(0, (outMin - inMin) / 15);
    }
}