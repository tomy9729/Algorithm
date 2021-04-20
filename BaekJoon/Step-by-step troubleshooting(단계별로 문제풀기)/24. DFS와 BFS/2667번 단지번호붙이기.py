#2667번 단지번호붙이기
def DFS(graph, now, visited) :
  visited[now] = 1 # 방문
  for i in graph[now] :
    if visited[i] == 0 : # 방문하지 않았다면 
      DFS(graph,i,visited) # 탐색

if __name__ == "__main__":  
  n = int(input())
  maps = []
  for i in range(n) : 
    maps.append(list(map(int,str(input()))))
  
  graph = [[] for i in range(n*n)]
  for i in range(n) : 
    for j in range(n) : 
      if maps[i][j] == 0 :
        continue
      elif maps[i][j] == 1 :
        if i+1 < n :
          if maps[i+1][j] == 1:
            graph[i*n+j].append((i+1)*n+j)
            graph[(i+1)*n+j].append(i*n+j)
        if i-1 >= 0 :
          if maps[i-1][j] == 1 and i-1 >=0 :
            graph[i*n+j].append((i-1)*n+j)
            graph[(i-1)*n+j].append(i*n+j) 
        if j+1 < n :
          if maps[i][j+1] == 1 and j+1 < n :
            graph[i*n+j+1].append(i*n+j)
            graph[i*n+j].append(i*n+j+1)
        if j-1 >= 0:
          if maps[i][j-1] == 1 and j-1 >=0 :
            graph[i*n+j-1].append(i*n+j)
            graph[i*n+j].append(i*n+j-1)
          
  visited = [0]*(n*n)
  result = [0]
  for i in range(n) : 
    for j in range(n) : 
      if maps[i][j] == 0 :
        continue
      else : 
        DFS(graph,i*n+j,visited)
        if result[-1] != sum(visited) : 
          result.append(sum(visited))
  
  result_sort = []
  print(len(result)-1)
  for i in range(0,len(result)-1) :
    result_sort.append(result[i+1]-result[i]) 
  result_sort.sort()
  for i in range(0,len(result)-1) :
    print(result_sort[i])
