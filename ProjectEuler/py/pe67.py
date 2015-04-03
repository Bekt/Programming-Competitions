"""P67: Correct."""
from pe18 import solve


if __name__ == '__main__':
    with open('pe67.txt', 'r') as f:
        n = solve(f.read().splitlines())
        # 7273
        print(n)
