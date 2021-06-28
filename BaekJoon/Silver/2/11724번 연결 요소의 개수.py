#11724번 연결 요소의 개수
# import sys
# sys.setrecursionlimit(10**6)
# input = sys.stdin.readline
def DFS(graph, now, visited) :
  visited[now] = True # 방문
  for i in graph[now] :
    if visited[i] == False : # 방문하지 않았다면 
      DFS(graph,i,visited) # 탐색

if __name__ == "__main__":
  n, m = map(int,input().split())
  visited = [False]*(n+1)
  connect = [[] for i in range(n+1)]
  for i in range(m) : 
    point1, point2 = map(int,input().split())
    connect[point1].append(point2)
    connect[point2].append(point1)
  answer = 0
  for i in range(1,n+1) : 
    if visited[i] :
      continue
    DFS(connect,i,visited)
    answer += 1
  print(answer)
