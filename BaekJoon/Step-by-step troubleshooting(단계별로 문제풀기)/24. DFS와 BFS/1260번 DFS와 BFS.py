#1260번 DFS와 BFS
def DFS(graph, now, visited,result) :
  visited[now] = True # 방문
  result.append(now)
  for i in graph[now] :
    if visited[i] == False : # 방문하지 않았다면 
      DFS(graph,i,visited,result) # 탐색

def BFS(graph, start, visited, result) :
  visited[start] = True # 방문
  result.append(start) 
  q = [start] # 큐에 시작 노들 삽입
  while q : 
    now = q.pop(0) # 현재 노드 : 큐에서 삭제된 노드
    for i in graph[now] : # 현재 노드의 자식들에 대해서
      if visited[i] == False :  # 방문하지 않았다면
        q.append(i)  # 큐에 삽입
        result.append(i) 
        visited[i] = True # 방문
  return result

if __name__ == "__main__":
  n, m, v = map(int,input().split())
  graph = [[] for i in range(n+1)] #각 노드가 저장된 노드들 저장
  for i in range(m) : 
    p1, p2 = map(int,input().split())
    graph[p1].append(p2)
    graph[p2].append(p1)
  for i in graph : 
    i.sort() # 정점이 작은 것부터 방문하기 위함
  result_dfs = []
  result_bfs = [] 

  visited = [False]*(n+1) # 방문 여부 
  DFS(graph,v,visited,result_dfs)

  visited = [False]*(n+1)
  BFS(graph,v,visited,result_bfs)

  for i in result_dfs : 
    print(i,end=' ')
  print()
  for i in result_bfs : 
    print(i,end=' ')
