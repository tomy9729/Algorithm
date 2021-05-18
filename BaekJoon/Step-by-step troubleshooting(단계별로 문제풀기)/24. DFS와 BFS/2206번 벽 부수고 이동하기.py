#2206번 벽 부수고 이동하기
def bfs() :
  q = [[0,0,0]] #첫번째 노드
  visit[0][0][0] = 1 #방문 + 거리
  while q : 
    x,y,wall = q.pop(0) # wall가 0이면 벽을 부수지 않음, 1이면 벽을 이미 부숨
    for i in range(4) : 
      nx = x + dx[i]
      ny = y + dy[i]
      if 0<= nx < n and 0<= ny < m : #이동 가능한 위치일 때
        if visit[nx][ny][wall] == -1 and maps[nx][ny] == 0 : #아직 방문하지 않았고, 벽이 없는 위치로 이동하는 경우 -> 벽을 이미 부쉈으면 1배열에 아니면 0배열에 저장
          visit[nx][ny][wall] = visit[x][y][wall]+1 
          q.append([nx,ny,wall])
        elif wall == 0 and maps[nx][ny] == 1 and visit[nx][ny][1] == -1 : # 아직 벽을 부수지 않았고, 벽을 부수려고 할 때
          visit[nx][ny][1] = visit[x][y][wall]+1
          q.append([nx,ny,1])
if __name__ == "__main__":
  n,m = map(int,input().split())
  maps = []
  for i in range(n) : 
    maps.append(list(map(int,list(input()))))
  
  visit = [[[-1] * 2 for _ in range(m)] for _ in range(n)]
  
  dx = [1,-1,0,0]
  dy = [0,0,1,-1]
  bfs()
  if visit[-1][-1][0] == -1 and visit[-1][-1][1] == -1 : 
    print(-1)
  elif visit[-1][-1][0] == -1 : 
    print(visit[-1][-1][1])
  elif visit[-1][-1][1] == -1 : 
    print(visit[-1][-1][0])
  else : 
    print(min(visit[-1][-1]))
