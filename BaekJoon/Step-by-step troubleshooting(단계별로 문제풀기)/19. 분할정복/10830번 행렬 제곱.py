#10830번 행렬 제곱
n,b = map(int,input().split()) # n*n행렬을 b제곱 해준다
A = [[0]*n for i in range(n)]
for i in range(n) : 
  A[i] = list(map(int,input().split()))

C = [[0]*n for i in range(n)]

def multi(mat1,mat2,size) : # mat1 행렬과 mat2 행렬의 곱
  mat3 = [[0]*size for i in range(size)]
  for i in range(size) : 
    for j in range(size) : 
      for l in range(size) : 
        mat3[i][j] += mat1[i][l]*mat2[l][j]%1000
  return mat3

def square(mat, n) : #제곱을 빠르게
  size = len(mat)
  if n == 1 : 
    return mat
  elif n%2 == 0 : 
    square_mat = square(mat,n//2)
    return multi(square_mat,square_mat,size)
  else : 
    square_mat = square(mat,n//2)
    return  multi(mat,multi(square_mat,square_mat,size),size)


C = square(A,b)
for i in range(n) : 
  for j in range(n) : 
    print(C[i][j]%1000,end=' ')
  print()
