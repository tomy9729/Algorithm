#1865번 웜홀.py
from collections import deque
import sys
input = sys.stdin.readline

#벨만 포드 알고리즘을 응용한 문제
def bellman_ford(start) : 
    N = len(graph)
    time = [int(1e9)]*N
    time[start]=0

    for i in range(N-2) :
        for node in range(1,N) : 
            for next in graph[node] : 
                if time[next[0]] > time[node] + next[1] : 
                    time[next[0]] = time[node] + next[1] 
    
    for node in range(1,N) : #음의 사이클이 있으면 "출발점으로 돌아왔을 때 시간이 되돌아가 있는 경우 가능"
            for next in graph[node] : 
                if time[next[0]] > time[node] + next[1] : #음의 사이클
                    return True 
    
    return False 
    
TC = int(input())
for t in range(TC):
    N,M,W = map(int,input().split())
    graph = [[]for _ in range(N+1)]
    
    for m in range(M):
        S,E,T = map(int,input().split())
        graph[S].append([E,T])
        graph[E].append([S,T])
    for w in range(W):
        S,E,T = map(int,input().split())
        graph[S].append([E,-1*T])

    check=False
    if bellman_ford(1) :
         check = True
    if check : 
        print("YES")
    else : 
        print("NO")
        
