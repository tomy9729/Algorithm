#2580번 스도쿠
import sys
#input = sys.stdin.readline
board = [[0]*9 for i in range(9)]
for i in range(9) : 
  board[i][0],board[i][1],board[i][2],board[i][3],board[i][4],board[i][5],board[i][6],board[i][7],board[i][8] = map(int,input().split())

empty = [] #빈칸 좌표를 저장
for i in range(9) : 
  for j in range(9) :
    if board[i][j] == 0 : 
      empty.append([i,j])

def can_fill_empty(point, i) : #point는 빈칸의 좌표, i는 빈칸에 들어갈 숫자 
  if i in board[point[0]] : #행에 같은 숫자가 있으면 false
    return False
  for x in range(9) : 
    if board[x][point[1]] == i : #열에 같은 숫자가 있으면 false
      return False
  start_x = point[0]-(point[0]%3)
  start_y = point[1]-(point[1]%3)
  for x in range(start_x,start_x+3) : #정사각형에 같은 숫자가 있으면 false
    for y in range(start_y,start_y+3) : 
      if board[x][y] == i :
        return False
  return True

def check(x) :
  if x == len(empty) : #답 출력
    for i in range(9) : 
      for j in range(9) : 
        print(board[i][j],end=' ')
      print()
    sys.exit() #답을 한번만 출력하기위해 프로그램 강제 종료
  else : 
    for i in range(1,10) : 
      if can_fill_empty(empty[x],i): #빈칸을 채우는 조건에 만족하면.
        board[empty[x][0]][empty[x][1]] = i
        check(x+1)
        board[empty[x][0]][empty[x][1]] = 0

check(0)
