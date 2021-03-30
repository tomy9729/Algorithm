# Level 1 신규 
def solution(new_id):    
    #1단계
    new_id = new_id.lower()
    #2단계 
    stack = []
    new_id = list(new_id)
    for i in range(len(new_id)) : 
        if new_id[i].isalpha() or new_id[i].isdigit() or new_id[i] == '-' or new_id[i] == '_' or new_id[i] == '.': 
            stack.append(new_id[i])
    #3단계  
    stack2 = []
    for i in range(len(stack)-1) :
        if stack[i] == '.' : 
            if stack[i+1] == '.' : 
                continue
        stack2.append(stack[i])
        
    stack2.append(stack[-1])
    stack = stack2
    
    #4단계#5단계
    if stack[0] == '.' : 
        stack.pop(0)
    if len(stack) == 0 :
        stack.append('a')
    if stack[-1] == '.' : 
        stack.pop()
    if len(stack) == 0 :
        stack.append('a')
    
    #6단계
    if len(stack) > 15 : 
        stack = stack[:15]
        if stack[14] == '.' : 
            stack.pop()
    
    #7단계
    if len(stack) <= 2 : 
        while len(stack) != 3 : 
            stack.append(stack[len(stack)-1])
    
    answer = ''.join(stack)
    return answer
