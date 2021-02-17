#10828번 스택
import sys
input = sys.stdin.readline
n = int(input())
stack = []
for i in range(n) : 
  command = input()[:-1] # sys.stdin.readline는 개행까지 포함한 문자열을 넘겨준다. 마지막 개행문자를 삭제
  if command[0:4] == 'push' : #push X: 정수 X를 스택에 넣는 연산이다.
    stack.append(int(command[5:]))
  elif command == 'pop' : #pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    if len(stack) == 0 : 
      print(-1)
    else : 
      print(stack.pop())
  elif command == 'size' : 
    print(len(stack)) #size: 스택에 들어있는 정수의 개수를 출력한다.
  elif command == 'empty' :  #empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    if len(stack) : 
      print(0)
    else : 
      print(1)
  elif command == 'top' : #top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    if len(stack) == 0 : 
      print(-1)
    else : 
      print(stack[len(stack)-1])
  else : 
    continue
