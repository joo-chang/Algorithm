# n x n 크기의 정사각형 공간
# 가장 왼쪽 위 좌표는 (1,1) 가장 오른쪽 아래 (n,n)
# L:왼쪽  R:오른쪽  U:위로 D:아래로
# 입력 : 첫번째 줄 공간 크기 n 둘째 줄 이동 계획서

n = int(input())
a = list(input().split())
x = 1
y = 1
for i in a:
    if i == "R":
        if x == n:
            pass
        else:
            x += 1
    elif i == "L":
        if x == 1:
            pass
        else:
            x -= 1
    elif i == "U":
        if y == 1:
            pass
        else:
            y -= 1
    elif i == "D":
        if y == n:
            pass
        else:
            y += 1

print(y, x)
