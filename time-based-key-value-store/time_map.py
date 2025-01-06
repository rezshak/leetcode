# https://leetcode.com/problems/time-based-key-value-store/

class TimeMap:

    def __init__(self):
        self.store = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.store:
            self.store[key] = []
        self.store[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.store:
            return ""

        values = self.store[key]
        left, right = 0, len(values) - 1

        # Binary search for largest timestamp <= target
        while left <= right:
            mid = (left + right) // 2
            if values[mid][0] <= timestamp:
                left = mid + 1
            else:
                right = mid - 1

        # If right < 0, no valid timestamp found
        return values[right][1] if right >= 0 else ""


def main() -> None:
    tm = TimeMap()
    tm.set("foo", "bar", 1)
    print(tm.get("foo", 1))  # Output: bar
    print(tm.get("foo", 3))  # Output: bar


if __name__ == "__main__":
    main()
