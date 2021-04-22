#1697번 숨바꼭질
from collections import deque
def BFS(n,k,visited,depth) : 
  q = deque()
  q.append(n)
  visited[n] = 1
  depth[n] = 1
  while q : 
    now = q.popleft()
    if now-1 >= 0 and visited[now-1] == 0 : 
      q.append(now-1)
      visited[now-1] = 1
      depth[now-1] = depth[now]+1
    if now+1 < 100001 and visited[now+1] == 0 : 
      q.append(now+1)
      visited[now+1] = 1
      depth[now+1] = depth[now]+1
    if 2*now < 100001 and visited[2*now] == 0 : 
      q.append(2*now)
      visited[2*now] = 1
      depth[2*now] = depth[now]+1
    if visited[k] == 1 :
      return depth[k]
if __name__ == "__main__":  
  n,k = map(int,input().split())
  visited = [0]*100001
  depth = [0]*100001
  print(BFS(n,k,visited,depth)-1)
