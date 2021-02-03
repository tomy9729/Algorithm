#4948번 베르트랑 공준

def is_prime_num(n) :
  for i in range(2,int((2*n)**0.5)+1):
      for j in range(2*i, 2*n+1, i):
          arr[j] = False

n = int(input())
while n != 0 : 
  arr = [False,False] + [True]*(2*n+1)
  is_prime_num(n)
  print(sum(arr[n+1:2*n+1]))
  n = int(input())
