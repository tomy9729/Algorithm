#1780번 종이의 개수
n = int(input())
num_paper = [[0]*n for i in range(n)]

for i in range(n) : 
  num_paper[i] = list(map(int,input().split()))
result = [0,0,0]

def check(x,y,size) : # 정사각형 종이로 사용 가능한지 여부 확인
  global num_paper
  num = num_paper[x][y] # 가장 처음 숫자
  for i in range(x,x+size) : # 정사각형의 모든 숫자에 대해서
    for j in range(y,y+size) : 
      if num_paper[i][j] != num :  # 하나라도 다르면
        return False # 불가능
  return True

def split(x,y,size) : # 종이를 9개로 나누는 함수
  global num_paper
  global result
  if check(x,y,size) : # 정사각형 종이로 사용 가능하면
    result[num_paper[x][y]+1] += 1 # result 0,1,2에 각각 -1 0 1의 개수 저장
  else : 
    next_size = size//3 # 새로운 정사각형의 크기
    for i in range(3) : 
      for j in range(3) : 
        split(x+next_size*i,y+next_size*j,next_size) # 9개의 정사각형으로 나눈 후 위 과정 반복

split(0,0,n)
print(result[0])
print(result[1])
print(result[2])
