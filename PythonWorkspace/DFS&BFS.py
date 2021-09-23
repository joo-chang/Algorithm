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


# n m 크기의 직사각형 형태의 미로에 갇혔습니다.
# 위치는 (1,1) 이며 미로의 출구는 (n,m) 위치에 존재. 한번에 한칸씩 이동가능
# 괴물 있는 부분 0 괴물 없는 부분 1
# 첫째 줄에 두 정수 n m 이 주어지고 각가의 수들은 공백 없이 붙여서 입력으로 제시
# 시각칸과 마지막칸은 항상 1
# ex) 5 6
# 101010
# 111111
# 000001
# 111111
# 111111
# 최소 이동 칸의 개수

from collections import deque


def bfs(x, y):
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if graph[nx][ny] == 0:
                continue

            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
    return graph[n - 1][m - 1]


n, m = map(int, input().split())

graph = []
for i in range(n):
    graph.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

print(bfs(0, 0))


