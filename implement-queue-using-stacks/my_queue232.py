# https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue232:

    def __init__(self):
        self.st1 = []
        self.st2 = []

    # T: O(1), S: O(1)
    def push(self, x: int) -> None:
        self.st1.append(x)

    # T: O(n), S: O(1)
    def pop(self) -> int:
        if not self.st2:
            while self.st1:
                self.st2.append(self.st1.pop())
        return self.st2.pop()

    # T: O(n), S: O(1)
    def peek(self) -> int:
        if not self.st2:
            while self.st1:
                self.st2.append(self.st1.pop())
        return self.st2[-1]

    # T: O(1), S: O(1)
    def empty(self) -> bool:
        return not self.st1 and not self.st2


def main() -> None:
    mq = MyQueue232()
    mq.push(1)
    mq.push(2)
    print(mq.peek())  # 1
    print(mq.pop())   # 1
    print(mq.empty())  # False


if __name__ == "__main__":
    main()
