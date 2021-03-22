#2740번 행렬 곱셈_슈트라센 알고리즘
def squard_2(num1,num2,num3) : 
  num = max(num1,num2,num3)
  squard = 0
  while num > 2**squard : 
    squard += 1 
  return 2**squard

n,m = map(int,input().split())
A = [[0]*m for i in range(n)]
for i in range(n) : 
  A[i] = list(map(int,input().split()))
m, k = map(int,input().split())
B = [[0]*k for i in range(m)]
for i in range(m) : 
  B[i] = list(map(int,input().split()))
size = squard_2(n,m,k)

for i in range(size) : 
  if i < n : 
    for j in range(size-m) : 
      A[i].append(0)
  else : 
    A.append([0]*size)
for i in range(size) : 
  if i < m : 
    for j in range(size-k) :
      B[i].append(0)
  else : 
    B.append([0]*size)

def plus(mat1, mat2) : 
  size = len(mat1)
  result = [[0]*size for i in range(size)]
  for i in range(size) : 
    for j in range(size) : 
      result[i][j] = mat1[i][j] + mat2[i][j]
  return result

def minus(mat1, mat2) : 
  size = len(mat1)
  result = [[0]*size for i in range(size)]
  for i in range(size) : 
    for j in range(size) : 
      result[i][j] = mat1[i][j] - mat2[i][j]
  return result

def strassen(A,B,size) : 
  C = [[0]*size for i in range(size)]
  if size == 1 : 
    C[0][0] = A[0][0]*B[0][0]
    return C
  
  size_ = size//2
  A11 = [[0]*size_ for i in range(size_)]
  A12 = [[0]*size_ for i in range(size_)]
  A21 = [[0]*size_ for i in range(size_)]
  A22 = [[0]*size_ for i in range(size_)]

  B11 = [[0]*size_ for i in range(size_)]
  B12 = [[0]*size_ for i in range(size_)]
  B21 = [[0]*size_ for i in range(size_)]
  B22 = [[0]*size_ for i in range(size_)]

  C11 = [[0]*size_ for i in range(size_)]
  C12 = [[0]*size_ for i in range(size_)]
  C21 = [[0]*size_ for i in range(size_)]
  C22 = [[0]*size_ for i in range(size_)]

  for i in range(size_) : 
    for j in range(size_) : 
      A11[i][j] = A[i][j]
      A12[i][j] = A[i][j+size_]
      A21[i][j] = A[i+size_][j]
      A22[i][j] = A[i+size_][j+size_]

      B11[i][j] = B[i][j]
      B12[i][j] = B[i][j+size_]
      B21[i][j] = B[i+size_][j]
      B22[i][j] = B[i+size_][j+size_]
  
  M1 = strassen(plus(A11,A22),plus(B11,B22),size_)
  M2 = strassen(plus(A21,A22),B11,size_)
  M3 = strassen(A11,minus(B12,B22),size_)
  M4 = strassen(A22,minus(B21,B11),size_)
  M5 = strassen(plus(A11,A12),B22,size_)
  M6 = strassen(minus(A21,A11),plus(B11,B12),size_)
  M7 = strassen(minus(A12,A22),plus(B21,B22),size_)

  C11 = plus(minus(plus(M1,M4),M5),M7)
  C12 = plus(M3,M5)
  C21 = plus(M2,M4)
  C22 = plus(plus(minus(M1,M2),M3),M6)

  for i in range(size_) : 
    for j in range(size_) : 
      C[i][j] = C11[i][j]
      C[i][j+size_] = C12[i][j]
      C[i+size_][j] = C21[i][j]
      C[i+size_][j+size_] = C22[i][j]

  return C

C = strassen(A,B,size)
for i in range(n) : 
  for j in range(k) : 
    print(C[i][j],end=' ')
  print()
