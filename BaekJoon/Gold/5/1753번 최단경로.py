#1753번 최단경로.py
import heapq
import sys
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

V,E = map(int,input().split())
k = int(input())

graph = [[]for _ in range(V+1)]
for i in range(E) : 
    u,v,w = map(int,input().split())
    graph[u].append([v,w])

root = [int(1e9)]*(V+1)

dijkstra(k)
for i in range(1,V+1) : 
    if root[i] == int(1e9) : 
        print("INF")
    else :
        print(root[i])
