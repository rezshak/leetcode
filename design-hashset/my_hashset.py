# https://leetcode.com/problems/design-hashset/

SIZE = 1_000_001


class MyHashSetBoolArray:

    def __init__(self):
        self.set = [False] * SIZE

    def add(self, key: int) -> None:
        self.set[key] = True

    def remove(self, key: int) -> None:
        self.set[key] = False

    def contains(self, key: int) -> bool:
        return self.set[key]

    def clear(self) -> None:
        self.set = [False] * SIZE


class MyHashSetBitArray:

    def __init__(self):
        self.bits = bytearray(SIZE // 8 + 1)

    def add(self, key: int) -> None:
        byte_index = self._get_byte_index(key)
        bit_index = self._get_bit_index(key)
        self.bits[byte_index] |= (1 << bit_index)

    def remove(self, key: int) -> None:
        byte_index = self._get_byte_index(key)
        bit_index = self._get_bit_index(key)
        self.bits[byte_index] &= ~(1 << bit_index)

    def contains(self, key: int) -> bool:
        byte_index = self._get_byte_index(key)
        bit_index = self._get_bit_index(key)
        return bool(self.bits[byte_index] & (1 << bit_index))

    def clear(self) -> None:
        self.bits = bytearray(SIZE // 8 + 1)

    def _get_byte_index(self, key: int) -> int:
        return key // 8

    def _get_bit_index(self, key: int) -> int:
        return key % 8


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
