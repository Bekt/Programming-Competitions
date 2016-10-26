"""Piling Up (Medium): https://www.hackerrank.com/challenges/piling-up"""
from collections import deque
def t(n, s):
    d = deque([int(c) for c in s.split()])
    prev = d.pop() if d[-1] >= d[0] else d.popleft()
    while len(d):
        if d[0] >= d[-1] and d[0] <= prev:
            prev = d.popleft()
        elif d[-1] > d[0] and d[-1] <= prev:
            prev = d.pop()
        else:
            return False
    return True

for _ in range(int(input())):
    print('Yes' if t(input(), input()) else 'No')
