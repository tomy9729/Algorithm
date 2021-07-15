#10026번 적록색약
def no_weakness(i,j,visit,n,graph) : 
  di = [1,0,-1,0]
  dj = [0,1,0,-1]
  visit[i][j] = True
  color = graph[i][j]
  q = [[i,j]]
  while q : 
    now = q.pop(0)
    now_i = now[0]
    now_j = now[1]
    for d in range(4) : 
      next_i = now_i+di[d]
      next_j = now_j+dj[d]
      if 0 <= next_i < n and 0 <= next_j < n : 
        if visit[next_i][next_j] == False and graph[next_i][next_j] == color:
          visit[next_i][next_j] = True
          q.append([next_i,next_j])
          

def weakness(i,j,visit,n,graph) : # R==G
  di = [1,0,-1,0]
  dj = [0,1,0,-1]
  visit[i][j] = True
  color = graph[i][j]
  if color == "R" or color == "G" :
    color = ["R","G"]
  else : 
    color = ["B"]
  q = [[i,j]]
  while q : 
    now = q.pop(0)
    now_i = now[0]
    now_j = now[1]
    for d in range(4) : 
      next_i = now_i+di[d]
      next_j = now_j+dj[d]
      if 0 <= next_i < n and 0 <= next_j < n : 
        if visit[next_i][next_j] == False and graph[next_i][next_j] in color:
          visit[next_i][next_j] = True
          q.append([next_i,next_j])

if __name__ == "__main__":
  n = int(input())
  graph = [[]for _ in range(n)]
  
  for i in range(n) : 
    graph[i] = list(input())

  no_w = 0
  
  visit = [[False]*n for _ in range(n)]
  for i in range(n) : 
    for j in range(n) : 
      if visit[i][j] == False : 
        no_weakness(i,j,visit,n,graph)
        no_w += 1

  w = 0
  visit = [[False]*n for _ in range(n)]
  for i in range(n) : 
    for j in range(n) : 
      if visit[i][j] == False : 
        weakness(i,j,visit,n,graph)
        w += 1

  print("%d %d"%(no_w,w))
