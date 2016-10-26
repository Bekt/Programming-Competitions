"""Leap Year (Medium): https://www.hackerrank.com/challenges/write-a-function"""
def is_leap(n):
    return n%400 == 0 or (n%4 == 0 and n%100 != 0)
