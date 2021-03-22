#2740번 행렬 곱셈
n,m = map(int,input().split())
A = [[0]*m for i in range(n)]
for i in range(n) : 
  A[i] = list(map(int,input().split()))
m, k = map(int,input().split())
B = [[0]*k for i in range(m)]
for i in range(m) : 
  B[i] = list(map(int,input().split()))

C = [[0]*k for i in range(n)]

def multi(i,j) : 
  temp = 0
  for l in range(m) : 
    temp += A[i][l]*B[l][j]
  return temp
  
for i in range(n) : 
  for j in range(k) : 
    C[i][j] = multi(i,j)
    print(C[i][j],end=' ')
  print()
