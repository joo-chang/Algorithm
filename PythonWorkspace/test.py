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