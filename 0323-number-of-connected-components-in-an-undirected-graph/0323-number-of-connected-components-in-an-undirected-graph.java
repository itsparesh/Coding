class Solution {
    int[] parent;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        int l = edges.length;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int res = n;

        for (int i = 0; i < l; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            res -= union(node1, node2);
        }
        return res;
    }

    private int findParent(int node) {
        int res = node;
        while (res != parent[res]) {
            // res = parent[parent[res]];
            res = parent[res];
        }
        return res;
    }

    private int union(int node1, int node2) {
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);

        if (parent1 == parent2) return 0;

        if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
        } else {
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
        }
        return 1;
    }
}