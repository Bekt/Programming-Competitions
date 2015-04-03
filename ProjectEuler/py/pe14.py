"""P14: Accepted"""

memo = {1: 1, 2: 2}


def collatz(n):
    seq = [n]
    while n != 1:
        n = n >> 1 if n % 2 == 0 else n*3 + 1
        if n in memo:
            for ind, c in enumerate(seq):
                memo[c] = memo[n] + len(seq) - ind
            return memo[seq[0]]
        seq.append(n)


if __name__ == '__main__':
    m, v = 0, 0
    for i in range(1000, 1000001):
        c = collatz(i)
        if c > v:
            v = c
            m = i
    # 837799 525
    print(m, v)
