// https://leetcode.com/problems/clone-graph/

import java.util.*;

class Node {
    int val;
    List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

}

class Solution133 {

    // T: O(V+E), S: O(V+E)
    public Node cloneGraph(Node node) {
        var visited = new HashMap<Node, Node>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Node, Node> visited) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node copy = new Node(node.val);
        visited.put(node, copy);

        for (Node neighbor : node.neighbors) {
            // Recursively clone each neighbor and add to the cloned node's neighbors
            copy.neighbors.add(dfs(neighbor, visited));
        }

        return copy;
    }

    // T: O(V+E), S: O(V+E)
    public Node cloneGraphBfs(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val));
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Create clone of the neighbor
                    visited.put(neighbor, new Node(neighbor.val));
                    // Add to queue for processing
                    queue.add(neighbor);
                }
                // Add cloned neighbor to current cloned node
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

    public static void main(String[] args) {
        var sol = new Solution133();
        var edges = new int[][] { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };

        Node originalGraph = createGraph(edges);
        Node clonedGraph = sol.cloneGraph(originalGraph);
        System.out.println("Original Graph:");
        printGraph(originalGraph);
        System.out.println("\nCloned Graph DFS:");
        printGraph(clonedGraph);

        // Verify that original and cloned graphs are different objects
        System.out.println("\nMemory Check:");
        System.out.println("Original Graph First Node: " + originalGraph);
        System.out.println("Cloned Graph First Node: " + clonedGraph);

        originalGraph = createGraph(edges);
        clonedGraph = sol.cloneGraphBfs(originalGraph);
        System.out.println("Original Graph:");
        printGraph(originalGraph);
        System.out.println("\nCloned Graph BFS:");
        printGraph(clonedGraph);

        // Verify that original and cloned graphs are different objects
        System.out.println("\nMemory Check:");
        System.out.println("Original Graph First Node: " + originalGraph);
        System.out.println("Cloned Graph First Node: " + clonedGraph);
    }

    private static Node createGraph(int[][] edges) {
        // Create nodes
        Node[] nodes = new Node[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            nodes[i] = new Node(i);
        }
        // Add edges
        for (int[] edge : edges) {
            nodes[edge[0]].neighbors.add(nodes[edge[1]]);
            nodes[edge[1]].neighbors.add(nodes[edge[0]]);
        }
        // Return first node
        return nodes[1];
    }

    private static void printGraph(Node node) {
        if (node == null) {
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print("Node " + current.val + " neighbors: ");

            for (Node neighbor : current.neighbors) {
                System.out.print(neighbor.val + " ");

                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
            System.out.println();
        }
    }

}
