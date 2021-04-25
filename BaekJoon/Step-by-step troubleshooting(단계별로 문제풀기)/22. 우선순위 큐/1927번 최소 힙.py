#1927번 최소 힙
import sys
input = sys.stdin.readline
import heapq    
if __name__ == "__main__":  
  heap = []
  n = int(input())
  for i in range(n) : 
    x = int(input())
    if x == 0 : 
      if len(heap) == 0 :
        print(0)
      else : 
        print(heapq.heappop(heap))
    else : 
      heapq.heappush(heap,x)
