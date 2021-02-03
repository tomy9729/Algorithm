#1929번 소수구하기
m,n = input().split()
m = int(m)
n = int(n)
arr = [True]*(n+1)
arr[1] = False
def is_prime_num(m,n) : 
  for i in range(2,n) : 
    j = 2
    while i*j <= n : 
      l = i*j
      arr[l] = False
      j += 1
      
is_prime_num(m,n)
for i in range(m,n+1) : 
  if arr[i] : print(i)
