#10989번 수 정렬하기3
import sys
input = sys.stdin.readline
n = int(input())
count = [0]*10001

for i in range(n) : 
  count[int(input())] += 1

for i in range(10001) : 
  for j in range(count[i]) : 
    print(i)
