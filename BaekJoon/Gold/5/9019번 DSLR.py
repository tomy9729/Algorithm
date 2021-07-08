#9019번 DSLR
from collections import deque
def DSLR(n, ins) : 
  d1 = n//1000
  d2 = (n-d1*1000)//100
  d3 = (n-d1*1000-d2*100)//10
  d4 = n-d1*1000-d2*100-d3*10
  if ins == "D" : 
    n = 2*n %10000
  elif ins == "S" : 
    if n==0 : 
      n = 9999
    else : 
      n -= 1
  elif ins == "L" : 
    n = d2*1000+d3*100+d4*10+d1
  elif ins == "R" : 
    n = d4*1000+d1*100+d2*10+d3
  return n

def BFS(a,b,visit):
  visit[a] = ""
  q = deque()
  q.append(a)
  instruction = ["D","S","L","R"]
  while q:
    now = q.popleft()
    if now == b : 
      return visit[now]
    for ins in instruction : 
      next = DSLR(now,ins)
      if visit[next] == -1 : 
        visit[next] = visit[now]+ins
        q.append(next)

if __name__ == "__main__":
  t = int(input())
  for _ in range(t) : 
    a,b = map(int,input().split())
    visit = [-1]*10000
    print(BFS(a,b,visit))
