from collections import deque


def fac(n):
    result = 1
    for i in range(1, n+1):
        result *= i
    return result

# 팩토리얼 재귀 함수
def factorial(n):
    if n <= 1:
        return 1
    return n * factorial(n-1)

print(fac(5))
print(factorial(5))

# 재귀 함수를 이용한 최대공약수 구하는 함수
def gcd(a, b):
    if a % b == 0:
        return b
    else:
        return gcd(b, a % b)

print(gcd(192,162))