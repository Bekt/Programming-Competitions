_, arr = input(), input().split()
a, b = set(input().split()), set(input().split())
print(sum([1 if e in a else -1 if e in b else 0 for e in arr]))
