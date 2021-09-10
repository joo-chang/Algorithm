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



# 8x8 좌표 평면상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는
# 경우의수를 출력하는 프로그램
# ex) 입력 a1 출력 2

input = input()
x = input[0]
y = int(input[1])
xlist = {'a' :1, 'b':2, 'c':3, 'd':4, 'e':5, 'f':6, 'g':7, 'h':8}
x = int(xlist[x])
count = 0

ways=[(2,-1),(2,1),(1,-2),(1,2),(-2,-1),(-2,1),(-1,-2),(-1,2)]

for way in ways:
    nx = x + way[0]
    ny = y + way[1]

    if (nx < 1 or nx > 8) or (ny < 1 or ny > 8):
        pass
    else :
        count +=1

print(count)


# 알파벳 대문자와 숫자로만 구성된 문자열이 입력으로 주어짐
# 이때 모든 알파벳을 오름차순으로 정렬하여 출력한 뒤, 그 뒤에 모든 숫자를 더한 값을 출력
# ex) K1KA5CB7 -> ABCKK13

string = input()
sum = 0
strlist = []
result = ''
for i in range(len(string)):
    if ord(string[i]) >= 48 and ord(string[i]) <= 57:
        sum += int(string[i])
    else:
        strlist.append(string[i])

strlist.sort()

for list in strlist:
    result += list
result += str(sum)
print(result)