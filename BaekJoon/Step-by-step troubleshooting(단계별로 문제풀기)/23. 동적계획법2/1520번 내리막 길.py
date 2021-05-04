#1520번 내리막 길
import sys
sys.setrecursionlimit(10 **9)

def dfs(x,y) : 
  if x == m-1 and y == n-1 : #도착하면 1을 반환
    return 1
  if count[x][y] != -1 : #이미 방문한 점이라면 바로 반환
    return count[x][y]
  count[x][y] = 0 #방문 표시
  for i in range(4) : #상하좌우에 대해서
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < m and 0 <= ny < n and maps[nx][ny] < maps[x][y] : #이동 가능한 점이라면
      count[x][y] += dfs(nx,ny) #개수 추가
  return count[x][y]
if __name__ == "__main__":  
  m,n = map(int,input().split())
  maps = []
  for i in range(m) : 
    maps.append(list(map(int,input().split())))
  count = [[-1]*n for i in range(m)] #count[x][y]는 (x,y)에서 목적지까지 갈 수 있는 방법의 수
  
  dx = [1,-1,0,0]
  dy = [0,0,1,-1]

  print(dfs(0,0))
