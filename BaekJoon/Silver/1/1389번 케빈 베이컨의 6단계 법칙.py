#1389번 케빈 베이컨의 6단계 법칙
def BFS(graph,start,visited) : 
  visited[start] = 0
  q = [start]
  while q : 
    now = q.pop(0)
    for i in graph[now] : 
      if visited[i] == -1 :
        q.append(i)
        visited[i] = visited[now]+1

if __name__ == "__main__":
  n,m = map(int,input().split())
  graph = [[]for i in range(n+1)]

  for i in range(m) : 
    human1, human2 = map(int,input().split())
    graph[human1].append(human2)
    graph[human2].append(human1)
  
  result = 99999999999
  answer = 0
  for i in range(1,n+1) : 
    visited = [-1]*(n+1)
    BFS(graph,i,visited)
    if sum(visited) < result :
      result = sum(visited)
      answer = i
  print(answer)
