# https://leetcode.com/problems/top-k-frequent-elements/

from typing import List
from collections import Counter
import heapq


class Solution347:

    # Using Bucket Sort
    # T: O(n), S: O(n)
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counts = Counter(nums)

        buckets = [[] for _ in range(len(nums) + 1)]

        for num, freq in counts.items():
            buckets[freq].append(num)

        result = []
        for i in range(len(buckets) - 1, -1, -1):
            result.extend(buckets[i])
            if len(result) >= k:
                return result[:k]
        return result

    # Using Min Heap
    # T: O(n log k), S: O(n)
    def topKFrequentMinHeap(self, nums: List[int], k: int) -> List[int]:
        counts = Counter(nums)

        heap = []
        for num, freq in counts.items():
            heapq.heappush(heap, (freq, num))
            if len(heap) > k:
                heapq.heappop(heap)

        return [num for _, num in sorted(heap, reverse=True)]


def main() -> None:
    sol = Solution347()
    nums1 = [1, 1, 1, 2, 2, 3]
    nums2 = [1]
    print(sol.topKFrequent(nums1, 2))  # [1, 2]
    print(sol.topKFrequentMinHeap(nums1, 2))  # [1, 2]
    print(sol.topKFrequent(nums2, 1))  # [1]
    print(sol.topKFrequentMinHeap(nums2, 1))  # [1]


if __name__ == "__main__":
    main()
