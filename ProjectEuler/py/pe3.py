"""P3: Accepted."""
from primes import is_prime


def solve(num):
    primes = [2,3,5,7,11,13,17,19]
    i = 0
    while True:
        if i >= len(primes):
            p = primes[-1] + 2
            while not is_prime(p):
                p += 2
            primes.append(p)
        if num % primes[i] == 0:
            num //= primes[i]
            i = 0
            if is_prime(num):
                break
        else:
            i += 1
    return num


if __name__ == '__main__':
    # 6857
    print(solve(600851475143))
