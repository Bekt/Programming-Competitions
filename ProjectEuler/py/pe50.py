"""P50: Accepted."""
from primes import (is_prime, gen_primes)


def solve(t):
    sums = [0]
    pg = gen_primes()
    while sums[-1] < t:
        sums.append(sums[-1] + next(pg))
    le = len(sums)
    m = (0, 0, 0)
    for i in range(1, le-1):
        # Terminate early.
        if sums[i] + sums[i+1] >= t:
            break
        for j in range(i+1, le):
            n = sums[j] - sums[i-1]
            if n < t and (j - i-1) > (m[2] - m[1]) and is_prime(n):
                m = (n, i, j)
    return m


if __name__ == '__main__':
    t = 1000000
    # (997651, 4, 546)
    print(solve(t))
