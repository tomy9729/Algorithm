#2156번 포도주 시식
n = int(input()) 
podoju = [] #포도주
for i in range(n) : 
  podoju.append(int(input()))
point = [False]*n

if n == 1 : #포도주 하나
   point[0] = podoju[0]
elif n == 2 : #포도주 둘
  point[1] = podoju[0] + podoju[1]
else :  #포두주 셋 이상
  point[0] = podoju[0]
  point[1] = podoju[0] + podoju[1]
  point[2] = max(podoju[1]+podoju[2],podoju[0]+podoju[2], podoju[0] + podoju[1])
  for i in range(3, n) : 
    point[i] = max(point[i-1], podoju[i]+podoju[i-1]+point[i-3], podoju[i]+point[i-2])
    #i번 째 포도주를 마실 차례 일 때 1. i번째와 i-1번째를 마시고 i-3까지의 최댓값 or i번째를 마시고 i-2까지의 최댓값 or i번째를 안마시고 i-1까지의 최댓값

print(point[n-1])
