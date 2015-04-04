def sieve(lim):
    """Returns the set of all primes under lim."""
    p = [True] * (lim // 2)
    for i in range(3, int(lim ** 0.5)+1, 2):
        if p[i//2]:
            p[i*i//2::i] = [False] * ((lim-i*i-1) // (2*i)+1)
    return set([2] + [2*i+1 for i in range(1, lim//2) if p[i]])


def is_prime(n):
    """Checks whether the number is prime."""
    if n < 2 or n % 2 == 0:
        return False
    return all(n % i != 0 for i in range(3, int(n ** 0.5)+1, 2))


def gen_primes(lim=None):
    """Infinite sequence of prime numbers."""
    d = {}
    n, c = 2, 0
    while lim is None or c < lim:
        if n not in d:
            yield n
            d[n*n] = [n]
            c += 1
        else:
            for p in d[n]:
                d.setdefault(p+n, []).append(p)
            del d[n]
        n += 1

