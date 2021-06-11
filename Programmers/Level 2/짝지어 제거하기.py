#Level 2 짝지어 제거하기.py
def solution(s):
    stack = []
    
    if len(s)%2 == 1 :
        return 0
    
    for i in s :
        if len(stack) == 0 : 
            stack.append(i)
        elif stack[-1] == i : 
            stack.pop()
        elif stack[-1] != i : 
            stack.append(i)
    if len(stack) == 0 : 
        return 1
    else : 
        return 0
