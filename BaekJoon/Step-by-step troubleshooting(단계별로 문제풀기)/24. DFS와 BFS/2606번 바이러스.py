#2606번 바이러스
def DFS(graph, now, visited) :
  visited[now] = 1 # 방문
  for i in graph[now] :
    if visited[i] == 0 : # 방문하지 않았다면 
      DFS(graph,i,visited) # 탐색

if __name__ == "__main__":  
  n = int(input())
  m = int(input())
  graph = [[] for i in range(n+1)]
  for i in range(m) : 
    p1, p2 = map(int,input().split())
    graph[p1].append(p2)
    graph[p2].append(p1)
  visited = [0]*(n+1)
  DFS(graph,1,visited)
  print(sum(visited)-1) # 1번 컴퓨터는 빼고 출력
