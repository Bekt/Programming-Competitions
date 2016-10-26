"""Word Order (medium): https://www.hackerrank.com/challenges/word-order"""
from collections import Counter as C
w = [input() for i in range(int(input()))]
c, s = C(w), set()
print(len(c))
for a in w:
    if a not in s:
        s.add(a)
        print(c[a], end=' ')
