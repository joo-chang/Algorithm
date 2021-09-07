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