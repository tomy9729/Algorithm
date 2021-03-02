#18258번 큐 2
import sys
input = sys.stdin.readline

n = int(input())
queue = []
front = 0
back = -1
for i in range(n) : 
  command = input()[:-1] # sys.stdin.readline는 개행까지 포함한 문자열을 넘겨준다. 마지막 개행문자를 삭제
  if command[0:4] == 'push' : #push X: 정수 X를 큐에 넣는 연산이다.
    queue.append(int(command[5:]))
    back += 1 
  elif command == 'pop' : #pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    if back - front == -1 : 
      print(-1)
    else : 
      print(queue[front])
      front+=1
  elif command == 'size' : 
    print(back-front+1) #size: 큐에 들어있는 정수의 개수를 출력한다.
  elif command == 'empty' :  #empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    if back - front == -1 : 
      print(1)
    else : 
      print(0)
  elif command == 'front' : #front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    if back-front == -1 : 
      print(-1)
    else : 
      print(queue[front])
  elif command == 'back' : #back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    if back-front == -1 : 
      print(-1)
    else : 
      print(queue[back])
  else : 
    continue
