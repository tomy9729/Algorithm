#7576번 토마토 
from collections import deque
def BFS(graph,x,y, visited, when) :
  q = deque()
  for i in range(len(x)) : #익은 토마토들 먼저 큐에 넣어준다.
    start = x[i]*m+y[i]
    when[start] = 1
    visited[start] = 1 # 방문
    q.append(start) # 큐에 시작 노들 삽입
  while q : 
    now = q.popleft() # 현재 노드 : 큐에서 삭제된 노드
    for i in graph[now] : # 현재 노드의 자식들에 대해서
      if visited[i] == 0 :  # 방문하지 않았다면
        when[i] = when[now]+1
        q.append(i)  # 큐에 삽입
        visited[i] = 1 # 방문
if __name__ == "__main__":  
  m,n = map(int,input().split())
  tomato = []
  x = []
  y = []
  graph = [[] for i in range(m*n)]
  visited = [0]*(m*n)
  for i in range(n) : 
    tomato.append(list(map(int,input().split()))) 

  not_tomato = 0 # 토마토가 없는 칸의 수 (-1)
  for i in range(n) : 
    for j in range(m) : 
      if tomato[i][j] == 1 : # 익은 토마토의 위치
        x.append(i)
        y.append(j)
      if tomato[i][j] == -1 : 
        not_tomato += 1
        continue
      else : 
        if i+1 < n : 
          if tomato[i+1][j] == 0 or tomato[i+1][j] == 1 :
            graph[i*m+j].append((i+1)*m+j)
            graph[(i+1)*m+j].append(i*m+j)
        if j+1 < m : 
            if tomato[i][j+1] == 0 or tomato[i][j+1] == 1 :
              graph[i*m+j].append(i*m+j+1)
              graph[i*m+j+1].append(i*m+j)
  when_tomato_ripe = [0]*(m*n) # 토마토가 익게 되는 시점
  BFS(graph,x,y,visited,when_tomato_ripe)
  if when_tomato_ripe.count(0) > not_tomato : 
    print(-1)
  else : 
    print(max(when_tomato_ripe)-1)
