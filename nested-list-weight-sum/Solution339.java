// https://leetcode.com/problems/nested-list-weight-sum/

import java.util.*;

class NestedInteger {

    private Integer value;
    private List<NestedInteger> list;

    public NestedInteger(int value) {
        this.value = value;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.value = null;
    }

    public boolean isInteger() {
        return value != null;
    }

    public Integer getInteger() {
        return value;
    }

    public List<NestedInteger> getList() {
        return list;
    }
}

class Solution339 {

    // T: O(n), S: O(d)
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> list, int depth) {
        int sum = 0;

        for (NestedInteger nested : list) {
            if (nested.isInteger()) {
                // If current element is an integer, add it to sum weighted by depth
                sum += nested.getInteger() * depth;
            } else {
                // If current element is a list, recursively process it at depth + 1
                sum += dfs(nested.getList(), depth + 1);
            }
        }

        return sum;
    }

    // T: O(n), S: O(n)
    public int depthSumBfs(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    total += nested.getInteger() * depth;
                } else {
                    queue.addAll(nested.getList());
                }
            }
            depth++;
        }
        return total;
    }

    public static void main(String[] args) {
        var sol = new Solution339();

        List<NestedInteger> nestedList = new ArrayList<>(); // [[1,1],2,[1,1]]

        // Create [1,1]
        List<NestedInteger> innerList1 = Arrays.asList(
                new NestedInteger(1),
                new NestedInteger(1));

        nestedList.add(new NestedInteger(innerList1)); // Add [1,1]
        nestedList.add(new NestedInteger(2)); // Add 2
        nestedList.add(new NestedInteger(innerList1)); // Add [1,1]

        System.out.println(sol.depthSum(nestedList)); // 10
        System.out.println(sol.depthSumBfs(nestedList)); // 10
    }

}
