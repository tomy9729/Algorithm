#1018번 체스파 다시 칠하기
import sys
n,m = input().split()
n = int(n)
m = int(m)
min = sys.maxsize

wb = [['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B','W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B','W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B','W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B','W']]
bw = [['B','W','B','W','B','W','B','W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B','W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B','W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B','W'],['W','B','W','B','W','B','W','B']]

board = [[0]*m for i in range(n)]
temp = [[0]*8 for i in range(8)]

for i in range(n) : 
  board[i] = input() 

for i in range(n-7) : 
  for j in range(m-7) : 
    count_wb = 0
    count_bw = 0
    for x,a in zip(range(i,i+8),range(8)) : 
      for y,b in zip(range(j,j+8),range(8)) : 
        temp[a][b] = board[x][y]
    for c in range(8) : 
      for d in range(8) : 
        if temp[c][d] != wb[c][d] : 
          count_wb += 1
        if temp[c][d] != bw[c][d] : 
          count_bw += 1
    if min > count_wb : 
      min = count_wb
    if min > count_bw : 
      min = count_bw

print(min)
