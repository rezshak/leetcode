// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

import java.util.*;

class Solution323 {

    // T: O(V+E), S: O(V+E)
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited);
                count++; // Increment the count for each connected component
            }
        }

        return count;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    // T: O(E+V), S: O(V)
    public int countComponentsUnionFind(int n, int[][] edges) {
        var uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.getCount();
    }

    class UnionFind {
        private int[] root;
        private int[] rank;
        private int count; // Number of connected components

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size; // Initially, each node is its own component

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x != root[x]) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        // Union by rank
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution323();

        int n1 = 5;
        int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        sol.countComponents(n1, edges1); // 2
        sol.countComponentsUnionFind(n1, edges1); // 2

        int n2 = 5;
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
        System.out.println(sol.countComponents(n2, edges2)); // 1
        System.out.println(sol.countComponentsUnionFind(n2, edges2)); // 1

        int n3 = 4;
        int[][] edges3 = { { 0, 1 }, { 2, 3 } };
        System.out.println(sol.countComponents(n3, edges3)); // 2
        System.out.println(sol.countComponentsUnionFind(n3, edges3)); // 2
    }

}
