#1012번 유기농 배추
def BFS(graph, start, visited) :
  visited[start] = True # 방문
  q = [start] # 큐에 시작 노들 삽입
  while q : 
    now = q.pop(0) # 현재 노드 : 큐에서 삭제된 노드
    for i in graph[now] : # 현재 노드의 자식들에 대해서
      if visited[i] == False :  # 방문하지 않았다면
        q.append(i)  # 큐에 삽입
        visited[i] = True # 방문

if __name__ == "__main__":  
  t = int(input())
  for i in range(t) : 
    m, n, k = map(int,input().split())
    graph = [[] for i in range(m*n)]
    visited = [0]*(m*n)
    farm = [[0]*m for i in range(n)]
    for j in range(k) : 
      x,y = map(int, input().split())
      farm[y][x] = 1

    for x in range(n) : 
      for y in range(m) : 
        if farm[x][y] == 0 :
          continue
        else : 
          if x+1 < n : 
            if farm[x+1][y] == 1 : # 배추가 붙어 있으면
              graph[x*m+y].append((x+1)*m+y) # 그래프에 추가
              graph[(x+1)*m+y].append(x*m+y)
          if y+1 < m :
            if farm[x][y+1] == 1 :
              graph[x*m+y].append(x*m+y+1)
              graph[x*m+y+1].append(x*m+y)
    count = 0
    for x in range(n) : 
      for y in range(m) : 
        if farm[x][y] == 1 and visited[x*m+y] == 0 : # 배추가 있고, 지렁이가 없으면
          BFS(graph,x*m+y,visited) # 지렁이 추가
          count += 1 # 지렁이 세기
    print(count)
