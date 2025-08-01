class Solution {
    
    HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    int[] output;       
    int index;          

    public int[] findOrder(int numCourses, int[][] prerequisites) {  
        output = new int[numCourses];
        index = numCourses - 1;
        for(int[] arr: prerequisites) {
            adjacencyMap.computeIfAbsent(arr[1], k -> new ArrayList<>()).add(arr[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return new int[0];
        }
        return output;
    }

    private boolean dfs(int node) {
        if (cycle.contains(node)) return false;
        if (visited.contains(node)) return true;
        cycle.add(node);
        for(int num: adjacencyMap.getOrDefault(node, new ArrayList<>())) {
            if (!dfs(num)) return false;
        }
        cycle.remove(node);
        visited.add(node);
        output[index--] = node;
        return true;
    }
}