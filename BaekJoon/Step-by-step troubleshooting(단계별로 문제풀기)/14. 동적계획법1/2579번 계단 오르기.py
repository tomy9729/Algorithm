#2579번 계단 오르기
n = int(input()) 
step = [] #계단
for i in range(n) : 
  step.append(int(input()))
point = [False]*n
if n == 1 : #계단이 하나
   point[0] = step[0]
elif n == 2 : #계단이 둘
  point[1] = step[0] + step[1]
else :  #계단이 셋 이상
  point[0] = step[0]
  point[1] = step[0] + step[1]
  point[2] = max(step[1]+step[2],step[0]+step[2])
  for i in range(3, n) : 
    point[i] = step[i] + max(point[i-2], point[i-3] + step[i-1])

print(point[n-1])
