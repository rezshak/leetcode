// https://leetcode.com/problems/network-delay-time/

import java.util.*;

record Pair<N, T>(N node, T time) {
}

class Solution743 {

    // T: O(V+E), S: O(V+E)
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build the graph as an adjacency list
        Map<Integer, List<Pair<Integer, Integer>>> adjList = createAdjList(times);

        // Step 2: Initialize distances array with high values
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 3: Queue for BFS; add the starting node
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(k, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            int node = curr.node();
            int time = curr.time();

            // Process each neighbor of the current node
            if (adjList.containsKey(node)) {
                for (Pair<Integer, Integer> neighbor : adjList.get(node)) {
                    int nextNode = neighbor.node();
                    int travelTime = neighbor.time();

                    // If we found a shorter path to nextNode, update and add to queue
                    if (dist[nextNode] > time + travelTime) {
                        dist[nextNode] = time + travelTime;
                        queue.offer(new Pair<>(nextNode, dist[nextNode]));
                    }
                }
            }
        }

        // Step 4: Calculate the result
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Not all nodes are reachable
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }

    // T: O((V+E)logV), S: O(V+E)
    public int networkDelayTimeDijkstra(int[][] times, int n, int k) {
        // Step 1: Build the graph as an adjacency list
        Map<Integer, List<Pair<Integer, Integer>>> adjList = createAdjList(times);

        // Step 2: Initialize distances array with high values
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 3: Priority queue for Dijkstra's algorithm
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Pair::time));
        minHeap.offer(new Pair<>(k, 0));

        while (!minHeap.isEmpty()) {
            Pair<Integer, Integer> current = minHeap.poll();
            int node = current.node();
            int time = current.time();

            // Skip processing if a shorter path to 'node' has already been found
            if (time > dist[node])
                continue;

            // Process each neighbor of the current node
            if (adjList.containsKey(node)) {
                for (Pair<Integer, Integer> neighbor : adjList.get(node)) {
                    int nextNode = neighbor.node();
                    int travelTime = neighbor.time();

                    // If we found a shorter path to nextNode, update and add to the queue
                    if (dist[nextNode] > time + travelTime) {
                        dist[nextNode] = time + travelTime;
                        minHeap.offer(new Pair<>(nextNode, dist[nextNode]));
                    }
                }
            }
        }

        // Step 4: Calculate the result
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Not all nodes are reachable
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }

    // T: O(E), S: O(V+E)
    private Map<Integer, List<Pair<Integer, Integer>>> createAdjList(int[][] times) {
        var adjList = new HashMap<Integer, List<Pair<Integer, Integer>>>();
        for (int[] entry : times) {
            int src = entry[0];
            int dst = entry[1];
            int time = entry[2];
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(new Pair<>(dst, time));
        }
        return adjList;
    }

    public static void main(String[] args) {
        var sol = new Solution743();
        int[][] times1 = {
                { 2, 1, 1 },
                { 2, 3, 1 },
                { 3, 4, 1 }
        };
        int n1 = 4;
        int k1 = 2;
        System.out.println(sol.networkDelayTime(times1, n1, k1)); // 2
        System.out.println(sol.networkDelayTimeDijkstra(times1, n1, k1)); // 2

        int[][] times2 = {
                { 1, 2, 1 },
                { 2, 3, 2 },
                { 1, 3, 4 }
        };
        int n2 = 3;
        int k2 = 1;

        System.out.println(sol.networkDelayTime(times2, n2, k2)); // 3
        System.out.println(sol.networkDelayTimeDijkstra(times2, n2, k2)); // 3

        int[][] times3 = {
                { 1, 2, 1 }
        };
        int n3 = 2;
        int k3 = 1;

        System.out.println(sol.networkDelayTime(times3, n3, k3)); // 1
        System.out.println(sol.networkDelayTimeDijkstra(times3, n3, k3)); // 1
    }

}
