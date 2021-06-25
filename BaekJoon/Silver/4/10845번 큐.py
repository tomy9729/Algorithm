#10845번 큐.py
import sys
input = sys.stdin.readline
from collections import deque
if __name__ == "__main__":
  q = deque()
  n = int(input())
  for i in range(n) : 
    instruntion = input()[:-1]
    if instruntion[:4] == "push" : 
      q.append(int(instruntion[5:]))
    elif instruntion == "pop" : 
      if len(q) == 0 : 
        print(-1)
      else :
        print(q.popleft())
    elif instruntion == "size" : 
      print(len(q))
    elif instruntion == "empty" : 
      if len(q) == 0 :
        print(1)
      else : 
        print(0)
    elif instruntion == "front" : 
      if len(q) == 0 :
        print(-1)
      else :
        print(q[0])
    elif instruntion == "back" : 
      if len(q)==0:
        print(-1)
      else :
        print(q[-1])
