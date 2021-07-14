#11403번 경로 찾기
def BFS(graph,i,j,visit) : 
  q = [i]
  while q :
    now = q.pop(0)
    for next in graph[now] : 
      if visit[next] == False : 
        visit[next] = True
        if next == j : 
          return 1
        q.append(next)
  return 0


if __name__ == "__main__":
  n = int(input())
  graph = [[] for _ in range(n)]
  for i in range(n) :
    g = list(map(int,input().split()))
    for j in range(n) : 
      if g[j] == 1 :
        graph[i].append(j)
  visit = [False]*n
  for i in range(n) :
    for j in range(n) : 
      visit = [False]*n
      print(BFS(graph,i,j,visit),end=" ")
    print()
