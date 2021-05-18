#7562번 나이트의 이동
def bfs(start) : 
  q = [start]
  visit[start[0]][start[1]] = 1
  while q :
    x,y=q.pop(0)
    if x == dest[0] and y == dest[1] : # 도착지에 도착하면 종료
      break
    for i in range(8): # 8개의 이동 위치에 대해서
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < l and 0<= ny < l and visit[nx][ny] == -1: #방문하지 않은 위치라면
        visit[nx][ny] = visit[x][y] +1  #방문
        q.append([nx,ny])
if __name__ == "__main__":
  t = int(input())
  dx = [1,2,1,-2,-1,2,-1,-2] #나이트가 움직일 수 있는 위치
  dy = [2,1,-2,1,2,-1,-2,-1]
  for i in range(t) : 
    l = int(input())
    start = list(map(int,input().split())) #시작지점
    dest = list(map(int,input().split())) #도착지점
    visit = [[-1]*l for j in range(l)] #방문 확인 및 이동 거리
    bfs(start)
    print(visit[dest[0]][dest[1]]-1)
