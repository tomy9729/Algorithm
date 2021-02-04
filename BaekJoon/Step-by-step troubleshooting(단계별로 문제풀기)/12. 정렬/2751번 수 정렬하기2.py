#2751번 수 정렬하기2
import sys
n = int(sys.stdin.readline())
arr = []

for i in range(n) : 
  arr.append(int(sys.stdin.readline()))

arr.sort()
for i in range(n) :
  print(arr[i])
