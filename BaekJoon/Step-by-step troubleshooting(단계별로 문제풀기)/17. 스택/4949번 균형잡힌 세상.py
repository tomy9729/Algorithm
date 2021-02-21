#4949번 균형잡힌 세상
parentheses = input()
while parentheses != '.' : 
  stack = []
  for j in range(len(parentheses)) : 
    if parentheses[j] == '(' or parentheses[j] == ')' or parentheses[j] == '[' or parentheses[j] == ']'  :
      stack.append(parentheses[j]) # 스택에 괄호를 하나씩 넣어준다
    if len(stack) > 1 :
      if stack[-2] == '(' and stack[-1] == ')' : #괄호가 완성되면 스택에서 괄호 삭제
        stack.pop()
        stack.pop()
      elif stack[-2] == '[' and stack[-1] == ']' : #괄호가 완성되면 스택에서 괄호 삭제
        stack.pop()
        stack.pop()
  if len(stack) == 0 : 
    print("yes")
  else : 
    print("no")
  parentheses = input()
