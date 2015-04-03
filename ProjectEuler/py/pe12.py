"""P12: Accepted."""


def factors(n):
    """Counts the number of distinct factors."""
    i, c, m = 1, 0, n
    while i < m:
        if n % i == 0:
            c += 2
            m = n // i
        i += 1
    return c


def div(c):
    """First triangle number to have over c divisors."""
    s, i = 1, 1
    while factors(s) <= c:
        i += 1
        s += i
    return s


if __name__ == '__main__':
    # 76576500
    print(div(500))
