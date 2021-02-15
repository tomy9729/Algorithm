#11051번 이항계수 2

n,k = map(int,input().split())
N=n
K=k
if k == 0 : 
  print(1)
else :
  while k != 1 : 
    n -= 1
    N = N*n
    
    k -= 1
    K = K*k

  print((N//K)%10007)
