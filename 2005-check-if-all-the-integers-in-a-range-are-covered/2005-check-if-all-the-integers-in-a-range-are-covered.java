class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        //Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] arr: ranges) {
            if (map.containsKey(arr[0])) {
                map.put(arr[0], Math.max(map.get(arr[0]), arr[1]));
            } else {
                map.put(arr[0], arr[1]);
            }  
        }

        boolean result = true;

        for (int i = left; i <= right; i++) {
            result = false;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if (entry.getKey() <= i && entry.getValue() >= i) {
                    result = true;
                    break;
                }
            }
            if (!result) {
                return false;
            }
        }
        
        return result;
    }
}