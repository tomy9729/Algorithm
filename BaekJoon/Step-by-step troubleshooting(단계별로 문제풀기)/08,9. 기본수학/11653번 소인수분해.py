#11653번 소인수분해
import math
n = int(input())

def factorization(m) :  
  for i in range(2,m+1):
     if m % i == 0:
       print(i)
       l = m // i
       if l == 1 : break
       factorization(l)
       break

factorization(n)
