#9020번 골드바흐의 추측
n = 10000
primes = []
#def prime(n) :
arr = [False,False] + [True]*(n+1)
for i in range(2,n+1):
  if arr[i]:
   primes.append(i)
  for j in range(2*i, n+1, i):
     arr[j] = False

def goldbach(num) : 
  x = num//2
  for i in range(x,num) : 
    if i in primes and num-i in primes : 
      return num-i,i
  
n = int(input())
for i in range(n) :
  even = int(input())
  a,b = goldbach(even)
  print("{} {}".format(a,b))
