#7662번 이중 우선순위 큐.py
import heapq
if __name__ == "__main__":
  t = int(input())
  for i in range(t) : 
    max_heap = []
    min_heap = []
    k = int(input())
    visited = [0]*k 
    for j in range(k) : 
      instruction = input()
      x = int(instruction[2:])
      if instruction[0] == "I" : 
        visited[j] = 1
        heapq.heappush(max_heap,(-x,j))
        heapq.heappush(min_heap,(x,j))
      elif x == 1 : 
        while len(max_heap) != 0 and visited[max_heap[0][1]] == 0 : #삭제한 숫자가 이미 삭제되어 있다면
          heapq.heappop(max_heap) # 다시 뽑기위해 제거
        if len(max_heap)!= 0 :
          visited[(heapq.heappop(max_heap))[1]] = 0 #숫자 삭제
      else : 
        while len(min_heap) != 0 and visited[min_heap[0][1]] == 0 :
          heapq.heappop(min_heap)
        if len(min_heap)!= 0 :
          visited[(heapq.heappop(min_heap))[1]] = 0
    
    while len(max_heap) != 0 and visited[max_heap[0][1]] == 0 :
      heapq.heappop(max_heap)
    while len(min_heap) != 0 and visited[min_heap[0][1]] == 0 :
      heapq.heappop(min_heap)
    if len(max_heap) != 0 and len(min_heap) != 0 : 
      print("%d %d"%(-max_heap[0][0], min_heap[0][0]))
    else : 
      print("EMPTY")
