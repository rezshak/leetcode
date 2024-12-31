# https://leetcode.com/problems/nested-list-weight-sum/

from typing import List, Union


class NestedInteger:

    def __init__(self, value: Union[int, List['NestedInteger']] = None):
        if isinstance(value, int):
            self.value = value
            self.list = None
        else:
            self.value = None
            self.list = value

    def isInteger(self) -> bool:
        return self.value is not None

    def getInteger(self) -> int:
        return self.value

    def getList(self) -> List['NestedInteger']:
        return self.list


class Solution339:

    # T: O(n), S: O(d)
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        return self.dfs(nestedList, 1)

    def dfs(self, nestedList: List[NestedInteger], depth: int) -> int:
        total = 0
        for nested in nestedList:
            if nested.isInteger():
                total += nested.getInteger() * depth
            else:
                total += self.dfs(nested.getList(), depth + 1)
        return total

    # T: O(n), S: O(n)
    def depthSumBfs(self, nestedList: List[NestedInteger]) -> int:
        queue = nestedList[:]
        depth = 1
        total = 0

        while queue:
            size = len(queue)
            for _ in range(size):
                nested = queue.pop(0)
                if nested.isInteger():
                    total += nested.getInteger() * depth
                else:
                    queue.extend(nested.getList())
            depth += 1

        return total


def main() -> None:
    sol = Solution339()

    nestedList = [
        NestedInteger([NestedInteger(1), NestedInteger(1)]),
        NestedInteger(2),
        NestedInteger([NestedInteger(1), NestedInteger(1)])
    ]

    print(sol.depthSum(nestedList))    # 10
    print(sol.depthSumBfs(nestedList))  # 10


if __name__ == "__main__":
    main()
