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



# 첫 번째 줄에 얼음 틀의 세로 길이 n 가로m 이 주어짐
# 두번째 줄부터 n +1 번쨰 까지 얼음 틀 형태
# 구멍이 뚫려있는 부분은 0 아닌부분은 1
# 한번에 만들 수 있는 얼음 개수
# 00110    0 뭉텅이 3개
# 00011
# 11111
# 00000

def dfs(x, y):
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False

    if graph[x][y] == 0:
        graph[x][y] = 1
        dfs(x - 1, y)
        dfs(x, y -1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False

n, m = map(int, input().split())

graph = []

for i in range(n):
    graph.append(list(map(int, input())))

result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1

print(result)


