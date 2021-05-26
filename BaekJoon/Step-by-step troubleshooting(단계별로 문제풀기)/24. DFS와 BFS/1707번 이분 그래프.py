#1707번 이분 그래프
#import sys
#input = sys.stdin.readline #입력 속도 상향
from collections import deque # 큐 성능 상향
def BFS(graph,visit,start) : 
  visit[start] = 1 #색은 1과 -1이 있으며 0이면 아직 방문하지 않은 노드
  q = deque()
  q.append(start)
  while q : 
    now = q.popleft()
    color = visit[now]
    for i in graph[now] : #현재 노드로부터 인접한 노드에 대해서
      if visit[i] == 0 :  # 방문하지 않은 노드라면
        q.append(i)   # 큐에 삽입
        visit[i] = -1*color # now와 다른 색으로 칠함
      elif visit[now] == visit[i] : #방문한 노드이고, now와 색이 같다면
        return False  # False 반환
  return True
if __name__ == "__main__":
  t = int(input())
  for i in range(t) : 
    v,e = map(int, input().split())
    visit = [0]*(v+1)
    graph = [[] for i in range(v+1)]
    
    for j in range(e) : 
      p1, p2 = map(int, input().split())
      graph[p1].append(p2)
      graph[p2].append(p1)
    
    result1 = BFS(graph,visit,1)

    visit = [0]*(v+1)
    result2 = BFS(graph,visit,p2)
    if result1 and result2 : 
      print("YES")
    else : 
      print("NO")
