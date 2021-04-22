#2178번 미로
def BFS(graph, start, visited, distance) :
  visited[start] = 1 # 방문
  q = [start] # 큐에 시작 노들 삽입
  while q : 
    now = q.pop(0) # 현재 노드 : 큐에서 삭제된 노드
    for i in graph[now] : # 현재 노드의 자식들에 대해서
      if visited[i] == 0 : 
        if distance[i] > distance[now]+1 :
          distance[i] = distance[now]+1 
        q.append(i)  # 큐에 삽입
        visited[i] = 1 # 방문
if __name__ == "__main__":  
  n,m = map(int,input().split())
  maze = []
  for i in range(n) : 
    maze.append(list(map(int,str(input()))))
  graph = [[] for i in range(n*m)]
  visited = [0]*(n*m)
  for i in range(n) : 
    for j in range(m) : 
      if maze[i][j] == 0 :
        continue
      else : 
        if i+1 < n : 
          if maze[i+1][j] == 1 :
            graph[i*m+j].append((i+1)*m+j)
            graph[(i+1)*m+j].append(i*m+j)
        if j+1 < m : 
          if maze[i][j+1] ==1 :
            graph[i*m+j].append(i*m+j+1)
            graph[i*m+j+1].append(i*m+j)
  distance = [n*m]*(n*m)
  distance[0] = 1
  BFS(graph,0,visited,distance) #DFS로 풀면 임의의 칸까지의 이동 거리가 최단 거리라는 보장이 없다.
  print(distance[n*m-1])
