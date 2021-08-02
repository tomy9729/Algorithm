#9935번 문자열 폭발.py
from collections import deque
str = input()
boom = input()

stack=deque()

for i in range(len(str)) : 
    stack.append(str[i])
    if len(stack) < len(boom) : 
        continue
    check = 0
    for j in range(len(stack)-len(boom),len(stack)):
        if(stack[j] != boom[j-len(stack)+len(boom)]):
            check=1
    if check==0:
        for j in range(len(stack)-len(boom),len(stack)):
            stack.pop()

if len(stack)==0 : 
    print("FRULA")
else :
    print("".join(stack))
