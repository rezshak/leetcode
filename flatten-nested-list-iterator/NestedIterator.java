// https://leetcode.com/problems/flatten-nested-list-iterator/

import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new RuntimeException();
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if (top.isInteger()) {
                return true;
            } else {
                stack.pop();
                List<NestedInteger> list = top.getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }
}

interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}

class ListNestedInteger implements NestedInteger {

    private List<NestedInteger> list;

    public ListNestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}

class SimpleNestedInteger implements NestedInteger {

    private Integer value;

    public SimpleNestedInteger(Integer value) {
        this.value = value;
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return null; // Not applicable for simple integer
    }

}
