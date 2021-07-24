#11779번 최소비용 구하기2.py
import sys
import heapq
import math
input = sys.stdin.readline

def dijkstra(start,buses,costs,root) : 
    q=[]
    root[start]=[start] #시작 경로 설정
    costs[start]=0
    heapq.heappush(q,(0,start,root[start])) #heap에 비용, 출발 노드, 경로 저장

    while q :
        cost, now, root_to_now = heapq.heappop(q) #가장 작은 가중치를 가진 노드 선택->현재 위치
        if costs[now] < cost : #선택한 노드의 가중치가, 이미 저장된 선택한 노드까지의 가중치보다 크다면 
            continue
        for bus in buses[now] : 
            next_cost = cost+bus[1] #now에서 버스를 타고 "다음 노드"로 가는 가중치 계산
            if next_cost < costs[bus[0]] : #가중치가 "이미 저장된 다음 노드로 가는 가중치" 보다 작다면
                costs[bus[0]]=next_cost #"다음노드"로 가는 가중치 갱신
                root[bus[0]] = root_to_now+[bus[0]]#경로도 갱신
                heapq.heappush(q,(next_cost,bus[0],root[bus[0]]))#heap에 추가
        

if __name__ == "__main__" :
    n = int(input())
    m = int(input())
    buses = [[]for _ in range(n+1)]
    for i in range(m):
        start, end, cost = map(int,input().split())
        buses[start].append([end,cost])
    
    costs = [int(1e9)]*(n+1)
    start, end = map(int,input().split())
    root=[[]for _ in range(n+1)]

    dijkstra(start,buses,costs,root)
    print(costs[end])
    print(len(root[end]))
    print(" ".join(map(str,root[end])))
