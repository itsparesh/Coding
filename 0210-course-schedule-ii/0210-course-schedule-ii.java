class Solution {
    
    HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    int[] output;       // array to store the result
    int index;          // current index to insert into output (starting from end)

    public int[] findOrder(int numCourses, int[][] prerequisites) {  
        output = new int[numCourses];
        index = numCourses - 1;
        for(int[] arr: prerequisites) {
            adjacencyMap.computeIfAbsent(arr[0], k -> new ArrayList<>()).add(arr[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(numCourses, i)) return new int[0];
        }
        return output;
    }

    private boolean dfs(int numCourses, int node) {
        if (cycle.contains(node)) return false;
        if (visited.contains(node)) return true;
        cycle.add(node);
        for(int num: adjacencyMap.getOrDefault(node, new ArrayList<>())) {
            if (!dfs(numCourses, num)) return false;
        }
        cycle.remove(node);
        visited.add(node);
        output[(numCourses - 1) - index] = node;
        index--;
        return true;
    }
}