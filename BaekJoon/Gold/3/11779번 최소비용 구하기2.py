#11779번 최소비용 구하기2.py
import sys
import heapq
import math
input = sys.stdin.readline

def dijkstra(start,visit,buses,costs,root) : 
    q=[]
    root[start]=[start]
    costs[start]=0
    heapq.heappush(q,(0,start,root[start]))
    visit[start]=True

    while q :
        cost, now, root_to_now = heapq.heappop(q)
        if costs[now] < cost :
            continue
        for bus in buses[now] : 
            next_cost = cost+bus[1]
            if next_cost < costs[bus[0]] : 
                costs[bus[0]]=next_cost
                root[bus[0]] = root_to_now+[bus[0]]
                heapq.heappush(q,(next_cost,bus[0],root[bus[0]]))
        

if __name__ == "__main__" :
    n = int(input())
    m = int(input())
    buses = [[]for _ in range(n+1)]
    for i in range(m):
        start, end, cost = map(int,input().split())
        buses[start].append([end,cost])
    
    visit = [False]*(n+1)
    costs = [int(1e9)]*(n+1)
    start, end = map(int,input().split())
    root=[[]for _ in range(n+1)]

    dijkstra(start,visit,buses,costs,root)
    print(costs[end])
    print(len(root[end]))
    print(" ".join(map(str,root[end])))
