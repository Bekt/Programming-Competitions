"""P18: Accepted."""


def solve(rows):
    """Find the maximum path sum in a triangle."""
    b = [list(map(int, r.split())) for r in rows]
    for i in range(len(b)-2, -1, -1):
        for j in range(len(b[i])):
            b[i][j] += max(b[i+1][j], b[i+1][j+1])
    return b[0][0]


if __name__ == '__main__':
    with open('pe18.txt', 'r') as f:
        n = solve(f.read().splitlines())
        # 1074
        print(n)

