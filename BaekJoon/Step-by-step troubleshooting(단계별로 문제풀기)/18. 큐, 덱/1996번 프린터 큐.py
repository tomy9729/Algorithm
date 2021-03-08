#1966번 프린터 큐
t = int(input()) # 테스트케이스 개수

for i in range(t) : 
  n,m = map(int,input().split()) 
  importance = list(map(int,input().split())) # 바로 원형큐로 사용
  importance.append(0)
  front = 0
  back = n
  count = 0
  while back != front : # 원형큐가 비어질 때 까지
    if importance[front] == max(importance) : # 첫 원소가 최댓값이라면
      count += 1 # 카운트 추가
      if front == m : # m이라면
        print(count) # count 출력
        break # while문 종료
      importance[front] = 0 # m이 아닐경우 삭제만 함
      front = (front+1) % len(importance) 
    else : # 첫 원소가 최댓값이 아니라면
      importance[back] = importance[front] # 첫 원소를 마지막 원소로 삽입
      importance[front] = 0 
      if front == m : # 만약 m이 었다면
        m = back # m 재설정
      front = (front+1)%len(importance) 
      back = (back+1)%len(importance) 
