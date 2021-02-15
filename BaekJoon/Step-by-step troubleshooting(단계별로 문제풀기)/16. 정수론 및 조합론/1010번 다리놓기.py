#1010번 다리놓기
t = int(input())
for i in range(t) : 
  n,m = map(int,input().split())
  N=n
  M=m
  while n!=1:
    n-=1
    N *= n 
    m-=1
    M *= m
  print(M//N)
