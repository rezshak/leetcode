# https://leetcode.com/problems/encode-and-decode-strings/

from typing import List


class Codec271:

    # T: O(n), S: O(n)
    def encode(self, strs: List[str]) -> str:
        encoded_parts = []
        for s in strs:
            encoded_parts.append(f"{len(s)}#{s}")
        return ''.join(encoded_parts)

    # T: O(n), S: O(n)
    def decode(self, s: str) -> List[str]:
        result = []
        i = 0
        while i < len(s):
            j = i
            while s[j] != '#':
                j += 1
            length = int(s[i:j])
            result.append(s[j+1:j+1+length])
            i = j + 1 + length
        return result


def main() -> None:
    codec = Codec271()
    encoded = codec.encode(["Hello", "World"])
    print("Encoded:", encoded)
    decoded = codec.decode(encoded)
    print("Decoded:", decoded)


if __name__ == "__main__":
    main()
