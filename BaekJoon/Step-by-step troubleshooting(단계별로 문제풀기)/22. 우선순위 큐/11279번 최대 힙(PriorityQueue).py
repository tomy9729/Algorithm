#11279번 최대 힙
from queue import PriorityQueue
if __name__ == "__main__":  
  heap = PriorityQueue()
  n = int(input())
  for i in range(n) : 
    x = int(input())
    if x == 0 : 
      if heap.empty() :
        print(0)
      else : 
        print(heap.get()[1])
    else : 
      heap.put((-x,x))
