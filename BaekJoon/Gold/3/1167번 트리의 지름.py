#1167번 트리의 지름.py
import heapq
import sys
input = sys.stdin.readline
def dijkstra(start) : 
    q=[]
    root[start]=0 #자기 자신에게 가는 것은 0
    heapq.heappush(q,(0,start)) #힙에 비용, 출발 노드 저장

    while q :
        cost, now = heapq.heappop(q)  # 가장 작은 가중치를 가진 노드 선택
        if root[now] < cost : #선택한 노드의 가중치가 이미 저장된 가중치보다 크면 실행x
            continue
        for next in graph[now] : 
            next_cost = cost+next[1] #현재 노드에서 다음 노드까지 가중치 계산
            if next_cost < root[next[0]] : #가중치가 더 작으면 
                root[next[0]]=next_cost #갱신
                heapq.heappush(q,(next_cost,next[0]))#heap에 추가

V =int(input())
graph = [[]for _ in range(V+1)]

for i in range(V):
    temp = list(map(int,input().split()))
    j=1
    while temp[j]!=-1:
        graph[temp[0]].append([temp[j],temp[j+1]])
        j+=2

diameter = 0
root = [int(1e9)]*(V+1)
root[0] = 0
dijkstra(1)
temp = max(root)
index = root.index(temp)

root = [int(1e9)]*(V+1)
root[0] = 0
dijkstra(index)
diameter = max(root)
print(diameter)
