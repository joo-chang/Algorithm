# 1874번 스택 수열
# 1부터 n까지 수를 스택에 넣었다가 뽑아 놓음으로써 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록한다 하자
# 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop연산을 수행해야하나
# 입력 - 첫 줄에 n. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 같은 정수 두번 나오는 일은 없다.
# 출력 - 입력된 수열을 만들기 위해 필요한 연산을 한줄에 한개씩 출력. push연산은 + pop 연산은 -로 표현. 불가능한 경우 no 출력

n = int(input())

nlist = []
stack = []
popstack = []


for i in range (0, n):
    nlist.append(int(input()))


for i in range(0, len(nlist)):
        if nlist[i] != :
            stack.append(j)
            popstack.append("+")
        else :
            popstack.append("-")
            break

print(stack)