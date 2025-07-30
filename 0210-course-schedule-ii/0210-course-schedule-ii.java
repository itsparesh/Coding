class Solution {
    
    HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    ArrayList<Integer> output = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {  
        for(int[] arr: prerequisites) {
            adjacencyMap.computeIfAbsent(arr[0], k -> new ArrayList<>()).add(arr[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(prerequisites, i)) return new int[0];
        }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int[][] prerequisites, int node) {
        if (cycle.contains(node)) return false;
        if (visited.contains(node)) return true;
        cycle.add(node);
        for(int num: adjacencyMap.getOrDefault(node, new ArrayList<>())) {
            if (!dfs(prerequisites, num)) return false;
        }
        cycle.remove(node);
        visited.add(node);
        output.add(node);
        return true;
    }
}