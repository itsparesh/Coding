class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int inHour = Integer.parseInt(loginTime.substring(0,2));
        int inMin = Integer.parseInt(loginTime.substring(3));
        int outHour = Integer.parseInt(logoutTime.substring(0,2));
        int outMin = Integer.parseInt(logoutTime.substring(3));

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