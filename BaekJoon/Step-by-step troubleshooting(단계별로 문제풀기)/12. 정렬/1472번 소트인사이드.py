#1472번 소트인사이드
n = int(input())

arr = []
while n :
  arr.append(n%10)
  n = n//10

arr.sort(reverse=True) #내림차순으로 정렬

for i in range(len(arr)) : 
  print(arr[i],end='')
