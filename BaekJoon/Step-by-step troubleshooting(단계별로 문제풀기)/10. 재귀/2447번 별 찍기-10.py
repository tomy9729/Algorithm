#2447번 별 찍기-10

def star(n) :
  if n == 3 : 
    return [['*','*','*'],['*',' ','*'],['*','*','*']]
  arr = [[0]*n for i in range(n)] #입력받은 크기만큼의 n*n 배열을 만든다.
  temp = star(n//3) #시간초과를 회피하기 위함. 반복문 전에 재귀함수를 한 번만 수행하도록 한다.
  for i in range(n) : 
    for j in range(n) : 
      if i >= n//3 and i < 2*n//3 and j >= n//3 and j < 2*n//3 : #빈칸으로 두는 조건
        arr[i][j] = ' '
      else :
        arr[i][j] = temp[i%(n//3)][j%(n//3)] #좌표에 해당하는 값만 가져온다.
  return arr

n=int(input())
x = star(n)
for i in range(n):
    for j in range(n):
        print(x[i][j],end='')
    print(end='\n')

# * * * * * * * * * 
# *   * *   * *   * 
# * * * * * * * * *        
# * * *       * * *        
# *   *       *   * 
# * * *       * * * 
# * * * * * * * * * 
# *   * *   * *   * 
# * * * * * * * * *
