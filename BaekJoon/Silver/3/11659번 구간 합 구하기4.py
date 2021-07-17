#11659번 구간 합 구하기4.py
import sys
input = sys.stdin.readline
if __name__ == "__main__":
  n,m = map(int,input().split())
  nums = list(map(int,input().split()))
  sums = [0]*(n+1)
  for i in range(n) :
    sums[i] = sums[i-1]+nums[i]
  for i in range(m) :
    i,j = map(int,input().split())
    print(sums[j-1]-sums[i-2])
