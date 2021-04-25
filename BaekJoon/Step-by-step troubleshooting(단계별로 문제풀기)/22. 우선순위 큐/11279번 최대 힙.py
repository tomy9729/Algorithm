#11279번 최대 힙
def insert(heap,x) : # 힙 삽입
  heap.append(x) # 힙 마지막에 x 삽입
  n = len(heap)-1
  while heap[n] > heap[n//2] and n >= 2: # x의 위치 찾기, x가 x의 부모보다 크다면 부모와 swap
    temp = heap[n]
    heap[n] = heap[n//2]
    heap[n//2] = temp
    n = n//2
def delete(heap,x) : # 힙 삭제
  print(heap[1]) # 현재 최댓값 출력
  heap[1] = heap[-1] # 힙 가장 처음 원소에 마지막 원소 삽입
  heap.pop() # 힙 길이 감소
  p = 1 # 루트 노드
  while True : # 가정 처음 원소로 온 값의 위치 찾기
    c = 2*p # 자식 노드
    if c+1 < len(heap) and heap[c] < heap[c+1] : # 왼쪽 자식과 오른쪽 자식 중 더 큰 자식 찾기
      c += 1
    if c >= len(heap) or heap[c] < heap[p] : # 더 이상 자식이 없거나 제 위치를 찾으면 종료
      break
    temp = heap[p] 
    heap[p] = heap[c]
    heap[c] = temp
    p = c 
    
if __name__ == "__main__":  
  heap = [0]
  n = int(input())
  for i in range(n) : 
    x = int(input())
    if x == 0 : 
      if len(heap) == 1 :
        print(0)
      else : 
        delete(heap,x)
    else : 
      insert(heap,x)
