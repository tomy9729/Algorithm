#2108번 통계학
import sys
input = sys.stdin.readline
n = int(input())
arr = []
count = [0]*8001 #음수도 나오기 때문에 음수의 크기를 고려하여 배열 크기 선정
count_max = 0

for i in range(n) : 
  temp = int(input())
  arr.append(temp)
  count[temp+4000] += 1

arr.sort()
print(round(sum(arr)/n))
print(arr[n//2])

for i in range(8001) : #최빈값이 여러개 나오는 경우를 확인하기 위함
  if count[i] == max(count) : 
    count_max += 1

if count_max == 1 : #최빈값이 한 개인 경우
  print(count.index(max(count))-4000)
else :              #최빈값이 여러개인 경우
  temp = 0
  for i in range(8001) : 
    if count[i] == max(count) and temp == 1 :
      print(i-4000)
      break
    if count[i] == max(count) : #최빈값 중 두번째로 큰 수를 출력하기 위함
      temp += 1

print((max(arr)-min(arr)))
