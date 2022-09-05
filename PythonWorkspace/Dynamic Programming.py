# 정수 x가 주어졌을 때, 사용할 수 있는 연산 4 ㄱ사지
# 1. 5로 나누어 떨어지면 5로 나눔
# 2. 3으로 나눈어떨어지면 3으로 나눔
# 3. 2로 나누어떨어지면 2로 나눔
# 4. x에서 1을 뺌
# 값 1을 만들려고 할 때 최소 연산  26 -> 25 -> 5 -> 1

x = int(input())

d = [0] * 30001

for i in range(2, x + 1):
    d[i] = d[i-1] + 1
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)
    if i % 5 == 0:
        d[i] = min(d[i], d[i // 5] + 1)

print(d[x])