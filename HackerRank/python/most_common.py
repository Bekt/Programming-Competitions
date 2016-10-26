"""Most Common (Medium): https://www.hackerrank.com/challenges/most-commons"""
from collections import Counter as C
for k, v in sorted(C(input()).most_common(), key=lambda e: (-e[1], e[0]))[:3]:
   print(k, v)
