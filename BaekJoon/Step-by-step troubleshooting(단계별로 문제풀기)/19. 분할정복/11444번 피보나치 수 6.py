#11444번 피보나치 수 6
n = int(input())
mod = 1000000007
def multi(mat1,mat2,size) : 
  mat3 = [[0]*size for i in range(size)]
  for i in range(size) : 
    for j in range(size) : 
      for l in range(size) : 
        mat3[i][j] += mat1[i][l]*mat2[l][j]%mod
  return mat3

def square(mat, n) : 
  size = len(mat)
  if n == 1 : 
    return mat
  elif n%2 == 0 : 
    square_mat = square(mat,n//2)
    return multi(square_mat,square_mat,size)
  else : 
    square_mat = square(mat,n//2)
    return  multi(mat,multi(square_mat,square_mat,size),size)

A = [[1,1],[1,0]] # 피보나치 수를 행렬을 통해 구하는 방법

if n == 0 : 
  print(0)
else : 
  C = square(A,n)
  print(C[0][1]%mod)
