class Solution {
    HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] arr: prerequisites) {
            adjacencyMap.computeIfAbsent(arr[0], k -> new ArrayList<>()).add(arr[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) return false;
        }
        return true;
    }

    private boolean dfs(int node) {
        if(cycle.contains(node)) return false;
        if(visited.contains(node)) return true;

        cycle.add(node);
        for(int num: adjacencyMap.getOrDefault(node, new ArrayList<>())) {
            if(!dfs(num)) return false;
        }
        cycle.remove(node);
        visited.add(node);
        return true;
    }
}