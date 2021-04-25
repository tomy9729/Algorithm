#1655번 가운데를 말해요
#import sys
#input = sys.stdin.readline
import heapq    
if __name__ == "__main__":  
  max_heap_left = [] # 중간값보다 작은 값들 - 최대 힙(왼쪽)
  min_heap_right = [] # 중간값보다 큰 값들 - 최소 힙(오른쪽)
  n = int(input())
  mid = int(input()) # 중간값
  print(mid)
  for i in range(n-1) : 
    x = int(input())
    if x > mid : # mid보다 크다면
      heapq.heappush(min_heap_right,x) # 오른쪽 힙에 삽입
      if len(min_heap_right) > len(max_heap_left)+1 : # 오른쪽 힙의 개수가 왼쪽 힙보다 2개 이상 많으면
        heapq.heappush(max_heap_left,(-mid,mid)) # 중간값 조정
        mid = heapq.heappop(min_heap_right)
    else : #mid보다 작으면
      heapq.heappush(max_heap_left,(-x, x)) # 왼쪽 힙에 삽입
      if len(max_heap_left) > len(min_heap_right) : #왼쪽 힙의 개수가 오른쪽 힙보다 1개 이상 많으면
        heapq.heappush(min_heap_right,mid) # 중간 값 조정
        mid = heapq.heappop(max_heap_left)[1]
    print(mid)
