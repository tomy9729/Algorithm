def is_it_right(s) :
    stack = []
    for i in range(len(s)) : 
        if len(stack) == 0 :
            stack.append(s[i])
        elif stack[-1] == '(' and s[i] == ')' : 
            stack.pop()
        elif stack[-1] == '[' and s[i] == ']' : 
            stack.pop()
        elif stack[-1] == '{' and s[i] == '}' : 
            stack.pop()
        else : 
            stack.append(s[i])
            
    if len(stack) == 0:
        return 1
    else : 
        return 0
def solution(s):
    answer = 0
    s = list(s)
    for i in range(len(s)) : 
        answer += is_it_right(s)
        s.append(s.pop(0))
    return answer
