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


#정수 n이 입력되면 00시 00분 00초부터 n시 59분 59초까지 모든 시각 중 3이 하나라도 포함되는
#모든 경우의수를 구하는 프로그램

n = int(input())

count = 0

for i in range(n+1):
    for j in range(60):
        for k in range(60):
            # if i%10 == 3 or j%10 == 3 or k%10 == 3 or i//10 == 3 or j//10 == 3 or k//10 == 3:
            #     count += 1
            if '3' in str(i) + str(j) + str(k):
                count += 1

print(count)


