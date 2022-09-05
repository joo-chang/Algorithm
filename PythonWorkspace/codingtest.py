# 2920번 음계
# 다장조 cdefgabC 8음계 12345로 바꿔 입력이 주어졌을 때, 오름차순 내림차순 믹스인지 판단하기

# 입력 - 8 개 숫자 입력
# 출력 - ascending, descending, mixed 출력

list = list(map(int, input().split()))

if list == sorted(list):
    print("ascending")
elif list == sorted(list, reverse=True):
    print("descending")
else:
    print("mixed")



# 2798번 블랙잭
# 카드 합이 21이 넘지 않는 한도 내에서 가장 크게 만드는 게임
# n장의 카드를 보이게 바닥에 놓고 딜러는 숫자 m을 외친다
# n장 카드중 3장의 카드를 고름
# 플레이어가 고른 카드 합이 m을 넘지않으면서 m과 최대한 가깝게 만들어야됨

n, m = map(int, input().split())
nlist = list(map(int, input().split()))
result = 0
sum = 0

for i in range(0, len(nlist)-2) :
    for j in range(i+1, len(nlist)-1):
        for k in range(j+1, len(nlist)):
            sum = nlist[i] + nlist[j] + nlist[k]
            if sum <= m :
                result = max(sum, result)

print(result)

