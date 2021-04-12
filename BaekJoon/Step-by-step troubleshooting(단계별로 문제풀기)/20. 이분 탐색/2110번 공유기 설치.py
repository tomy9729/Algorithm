#2110번 공유기 설치
def internet_distance(x, c) :
  start = 1 #최소 거리
  end = x[-1]-x[0] #최대 거리
  mid = (start + end)//2

  while start <= end : 
    internet = [-1]*c # 설치할 공유기의 위치를 저장
    internet[0] = x[0] # 첫 공유기는 항상 첫번째 집에 설치
    x_index = 1
    for i in range(c)[1:] : 
      while True : 
        if x_index >= len(x) :
          break 
        if x[x_index] - internet[i-1] >= mid : # 다음으로 설치할 집의 위치부터 그 전집까지의 위치가 mid보다 크면
          internet[i] = x[x_index] # 공유기 설치
          break
        else : 
          x_index += 1
    if -1 not in internet : # 공유기를 모두 설치 했다면
      start = mid + 1 # 더큰 "가장 인접한 공유기의 거리"가 있을 수 있으므로 mid를 크게 한다.
    else : 
      end = mid - 1
    mid = (start+end)//2
  return mid

if __name__ == "__main__":
  n, c = map(int, input().split())
  x = []
  for i in range(n):
    x.append(int(input()))
  x.sort()
  if c == 2 :
    print(x[-1]-x[0])
  else : 
    print(internet_distance(x,c))
