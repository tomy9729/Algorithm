#11286번 절댓값 힙
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
        print(heapq.heappop(heap)[1])
    else : 
      heapq.heappush(heap,(abs(x),x))
