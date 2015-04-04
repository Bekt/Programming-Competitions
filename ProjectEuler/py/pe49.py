"""PE49: Correct. This is a pretty ghetto solution."""
from primes import sieve
from collections import defaultdict


def check(li, seq):
    le = len(li)
    for i in range(0, le-2):
        for j in range(i+1, le-1):
            d = li[j] - li[i]
            nums = [li[i], li[j]]
            for k in range(j+1, le):
                if li[k] - nums[-1] == d:
                    nums.append(li[k])
            if len(nums) >= seq:
                print(d, nums)


def solve(seq=3):
    pr = sieve(10000).difference(sieve(1000))
    pr = sorted(pr)
    d = defaultdict(list)
    for p in pr:
        s = set(str(p))
        d[''.join(sorted(s))].append(p)
    for k, v in d.items():
        if len(v) > seq:
            check(v, seq)


if __name__ == '__main__':
    # 3330 [1487, 4817, 8147]
    # 3330 [2969, 6299, 9629]
    solve(3)
