# 그리디 기본 연습 문제


# 어떠한 수 n이 1이 될 때까지 다음의 두 과정 중 하나를 반복 적으로 선택하여 수행
# 단, 두 번째 연산은 n이 k로 나누어 떨어질 때만 선택 가능
# 1. n에서 1을 뺀다
# 2. n을 k로 나눈다.
# n과 k가 주어질 때 n이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 최소 횟수를 구해라

n,k = map(int, input().split())
count = 0
while True:
    if n % k == 0:
        n = n / k
        count += 1
        if n == 1 :
            break
    else :
        n -= 1
        count += 1

print(count)

# 각 자리가 숫자로만 이루어진 문자열 s가 주어졌을 때, 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에
# 'x' 혹은 '+' 연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수를 구하는 프로그램을 작성
# 모든 연산은 왼쪽부터 순서대로 이루어진다고 가정

s = input()
result = int(s[0])
for i in range(1, len(s)):
    if (result + int(s[i])) > (result * int(s[i])):
        result += int(s[i])
    else:
        result *= int(s[i])

print(result)

# n명의 모험가를 대상으로 공포도 측정
# 공포도가 x인 모험가는 반드시 x명 이상으로 구성한 모험가 그룹에 참여해야 함
# 최대 몇 개의 그룹을 만들 수 있을지. 여행을 떠날 수 있는 그룹의 최댓값을 구하는 프로그램 작성

n = int(input())
x = list(map(int, input().split()))
x.sort()

result = 0
count = 0

for i in x:
    result += 1
    if result >= i :
        result = 0
        count += 1

print(count)





























