#16928번 뱀과 사다리 게임
from collections import deque
def BFS(visit, ladder_snake) : 
  q = deque()
  q.append(1)
  visit[1] = 0
  while q : 
    now = q.popleft()
    for dice in range(1,7) : 
      next = now+dice    
      if next > 100 : 
        break
      if next in ladder_snake : 
        next = ladder_snake[next]
      if visit[next] == -1 :
        visit[next] = visit[now]+1
        q.append(next)
  return visit[100]
  
if __name__ == "__main__":
  n,m = map(int,input().split())
  ladder_snake = {}
  for _ in range(n+m) : 
    start, end = map(int,input().split())
    ladder_snake[start] = end
  visit = [-1]*101
  print(BFS(visit,ladder_snake))
