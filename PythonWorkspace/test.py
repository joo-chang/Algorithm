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
