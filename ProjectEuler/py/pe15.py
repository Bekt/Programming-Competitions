"""P15: Accepted."""


def solve(pt, s, memo):
    """Depth first search with memoization.
    Note: This can also be solved using combinatorics."""
    if pt[0] > s or pt[1] > s:
        return 0
    if pt[0] == s and pt[1] == s:
        return 1
    if pt in memo:
        return memo[pt]
    rpt = (pt[0], pt[1]+1)
    dpt = (pt[0]+1, pt[1])
    memo[rpt] = solve(rpt, s, memo)
    memo[dpt] = solve(dpt, s, memo)
    return memo[rpt] + memo[dpt]


if __name__ == '__main__':
    grid = 20
    # 137846528820
    print(solve((0, 0), grid, {}))
