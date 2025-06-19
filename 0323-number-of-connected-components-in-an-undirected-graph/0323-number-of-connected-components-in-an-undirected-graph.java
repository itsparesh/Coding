class Solution {
    int[] rank;
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        int res = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            
            res -= unionOfNodes(a, b);
        }
        return res;
    }

    private int findParent(int node) {
        int res = node;
        if (res != parent[res]) {
            res = parent[parent[res]];
            res = parent[res];
        }
        return res;
    }

    private int unionOfNodes(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA == parentB) return 0;

        if (rank[parentA] > rank[parentB]) {
            rank[parentA] += rank[parentB];
            parent[parentB] = parentA;
        } else {
            rank[parentB] += rank[parentA];
            parent[parentA] = parentB;
        }
        return 1;
    }
}