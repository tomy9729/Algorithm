#11279번 최대 힙
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
      heapq.heappush(heap, (-x,x))
