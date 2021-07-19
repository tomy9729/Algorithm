#14500번 테트로미노.py
def DFS(count,sum_val,i,j) : 
  if count >= 4 :
    global result
    result = max(result,sum_val)
    return
  di = [0,1,0,-1]
  dj = [1,0,-1,0]
  for index in range(4) : 
    next_i = i+di[index]
    next_j = j+dj[index]
    if 0<= next_i <n and 0<= next_j <m :
      if visit[next_i][next_j] == False : 
        visit[next_i][next_j] = True
        DFS(count+1,sum_val+paper[next_i][next_j],next_i,next_j)
        visit[next_i][next_j] = False
def another_shape(i,j) :
  global result
  di = [[-1,1,0],[-1,0,0],[0,-1,1],[0,0,1]]
  dj = [[0,0,-1],[0,1,-1],[1,0,0],[1,-1,0]]
  for ni in range(4):
    sum_val = paper[i][j]
    for nj in range(3) :
      next_i = i+di[ni][nj]
      next_j = j+dj[ni][nj]
      if 0<=next_i<n and 0<=next_j<m:
        sum_val += paper[next_i][next_j]
    result = max(result,sum_val)

if __name__ == "__main__":
  n,m = map(int,input().split())
  visit = [[False]*m for _ in range(n)]
  paper = []
  result = 0
  for i in range(n):
    paper.append(list(map(int,input().split())))

  for i in range(n) :
    for j in range(m) : 
      visit[i][j]=True
      DFS(1,paper[i][j],i,j)
      visit[i][j]=False
      another_shape(i,j)
  print(result)
