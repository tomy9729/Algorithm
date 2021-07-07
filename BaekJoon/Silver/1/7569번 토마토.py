#7569번 토마토 
from collections import deque
def BFS(tomato,start,m,n,h) : 
  x = [1,-1,0,0,0,0]
  y = [0,0,1,-1,0,0]
  z = [0,0,0,0,1,-1]
  num = 0
  q = deque(start)
  day = 0
  while q : 
    now = q.popleft()
    for i in range(6) : 
      nx = now[2]+x[i]
      ny = now[1]+y[i]
      nz = now[0]+z[i]
      if (nx >=0 and nx < m) and (ny >=0 and ny < n) and (nz >=0 and nz < h) :
        if tomato[nz][ny][nx] == 0 :
          q.append([nz,ny,nx])
          tomato[nz][ny][nx] = tomato[now[0]][now[1]][now[2]]+1
          day = max(day,tomato[nz][ny][nx])
          num += 1
  return num, day
if __name__ == "__main__":
  m,n,h = map(int,input().split())
  tomato = [[[0 for _ in range(m)] for _ in range(n)] for _ in range(h)]
  start = []
  zero = 0
  for i in range(h) : 
    for j in range(n) : 
      tomato[i][j] = list(map(int,input().split()))
      for l in range(m) : 
        if tomato[i][j][l] == 1 : 
          start.append([i,j,l])
        elif tomato[i][j][l] == 0 : 
          zero += 1
  answer = BFS(tomato,start,m,n,h)
  if answer[0]!= zero :
    print(-1)
  elif answer[1] == 0 :
    print(0)
  else : 
    print(answer[1]-1)  
