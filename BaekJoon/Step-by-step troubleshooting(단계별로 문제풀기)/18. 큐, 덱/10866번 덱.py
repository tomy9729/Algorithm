#10866번 덱
import sys
input = sys.stdin.readline

n = int(input())
deque = []

for i in range(n) : 
  command = input()[:-1] # sys.stdin.readline는 개행까지 포함한 문자열을 넘겨준다. 마지막 개행문자를 삭제
  if command[0:10] == 'push_front' : #push_front X: 정수 X를 덱의 앞에 넣는다.
    deque.insert(0,int(command[11:]))
   
  elif command[0:9] == 'push_back' : #push_back X: 정수 X를 덱의 뒤에 넣는다.
    deque.append(int(command[10:]))
   
  elif command == 'pop_front' : #pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    if len(deque) == 0 : 
      print(-1)
    else : 
      print(deque[0])
      deque.pop(0)
  elif command == 'pop_back' : #pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    if len(deque) == 0 : 
      print(-1)
    else : 
      print(deque[len(deque)-1])
      deque.pop()
  elif command == 'size' : 
    print(len(deque)) #size: 덱에 들어있는 정수의 개수를 출력한다.
  elif command == 'empty' :  #empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    if len(deque) == 0 : 
      print(1)
    else : 
      print(0)
  elif command == 'front' : #front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    if len(deque) == 0 : 
      print(-1)
    else : 
      print(deque[0])
  elif command == 'back' : #back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    if len(deque) == 0 : 
      print(-1)
    else : 
      print(deque[len(deque)-1])
  else : 
    continue
