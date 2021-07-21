#1043번 거짓말
from collections import deque
def BFS(visit,graph,start,know_people):
  visit[start]=True
  q = deque()
  q.append(start)
  while q :
    now = q.popleft()
    now = list(graph[now])
    for next in now : 
      if visit[next]==False :
        visit[next]=True
        if next in know_people : 
          return 0
        q.append(next)
  return 1
if __name__ == "__main__" :
  n,m = map(int,input().split())
  graph = [set() for _ in range(n+1)]

  know_people = list(map(int,input().split()))
  know_people = set(know_people[1:])
  
  partys=[]
  for i in range(m) :
    party = list(map(int,input().split()))
    people_num = party[0]
    party = party[1:]
    partys.append(party)
    for i in range(people_num) :
      graph[party[i]] = graph[party[i]] | (set(party[:i]) | set(party[i+1:]))

  count = 0
  visit = [False]*(n+1)
  for i in range(m) :
    for j in partys[i] :
      if j in know_people : 
        break
      visit = [False]*(n+1)
      can_lie = BFS(visit,graph,j,know_people)
      if can_lie == 1 :
        count += 1
        break
  print(count)
