#9012번 괄호
t = int(input())
for i in range(t) : 
  parentheses = input()
  stack = []
  for j in range(len(parentheses)) : 
    stack.append(parentheses[j]) # 스택에 괄호를 하나씩 넣어준다
    if len(stack) > 1 :
      if stack[-2] == '(' and stack[-1] == ')' : #괄호가 완성되면 스택에서 괄호 삭제
        stack.pop()
        stack.pop()
  if len(stack) == 0 : #최종적으로 스택에 아무것도 없으면 YES
    print("YES")
  else : 
    print("NO")   
