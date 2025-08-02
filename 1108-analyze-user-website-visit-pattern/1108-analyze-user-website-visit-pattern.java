class Solution {
    class Pattern {
        String username;
        int timestamp;
        String website;

        Pattern(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, List<String>> userSiteMap = new HashMap<>();
        HashMap<List<String>, Integer> seqMap = new HashMap<>();
        List<Pattern> patternList = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < username.length; i++) {
            patternList.add(new Pattern(username[i], timestamp[i], website[i]));
        }

        Collections.sort(patternList, (a, b) -> a.timestamp - b.timestamp);

        for (Pattern pattern: patternList) {
            userSiteMap.computeIfAbsent(pattern.username, list -> new ArrayList<String>()).add(pattern.website);
        }

        for (List<String> webList: userSiteMap.values()) {
            Set<List<String>> set = generateSetLists(webList);
            for (List<String> list: set) {
                seqMap.put(list, seqMap.getOrDefault(list, 0) + 1);
            }
        }


        for (Map.Entry<List<String>, Integer> entry: seqMap.entrySet()) {
            List<String> key = entry.getKey();
            int value = entry.getValue();
            if (value > max) {
                max = value;
                res = key;
            } else if (value == max) {
                if (key.toString().compareTo(res.toString()) < 0) {
                    res = key;
                }
            }
        }

        return res;
    }

    private Set<List<String>> generateSetLists(List<String> list) {
        Set<List<String>> set = new HashSet<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                for (int k = j+1; k < size; k++) {
                    set.add(Arrays.asList(list.get(i), list.get(j), list.get(k)));
                }
            }
        }
        return set;
    }
}