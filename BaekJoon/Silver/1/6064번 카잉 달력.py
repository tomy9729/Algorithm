#6064번 카잉 달력
import sys
input = sys.stdin.readline
from math import gcd
if __name__ == "__main__":
  t = int(input())
  for i in range(t) : 
    m,n,x,y = map(int,input().split())
    common_multiple = (m*n)//gcd(m,n)
    num = 0
    answer = -1
    while m*num+x <= common_multiple : 
      if (m*num+x-1)%n+1 == y : 
        answer = m*num+x
        break
      num += 1
    print(answer)
