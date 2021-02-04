#9663번 N-Queen
n = int(input()) 
count = 0
arr = [0]*(n+1)
arr[0] = 100

def is_queen_no_die(arr, i) : # 새로 들어오는 퀸의 위치가 죽으면 False를 반환
  new_queen = arr.index(0)
  j = 1
  while arr[j] : #퀸이 존재하는 배열까지만 진행
    if arr[j] == i or abs(j - new_queen) == abs(arr[j] - i) : #퀸이 죽는 경우
      return False
    j += 1
  return True

def check(x) :
  if x == n+1 : 
    global count
    count += 1   
  else : 
    for i in range(1,n+1) :
      if x == 1 :  #첫 번째 퀸은 검사할 필요가 없음
        if n%2 == 0 and i > n//2 : # n이 짝수일때는 첫 번째 퀸을 반까지만 진행하고 나온 count값에 두배한다.
          break
        arr[x] = i
        check(x+1)
        arr[x] = 0
      elif is_queen_no_die(arr,i) : #퀸이 죽을 경우 수행하지 않음
        arr[x] = i
        check(x+1)
        arr[x] = 0

check(1)
if n%2 == 0 :
  print(count*2)
else : print(count)
