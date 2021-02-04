#9641번 파도반 수열

T = int(input())
p = [0]*101
p[1] = 1
p[2] = 1
p[3] = 1
p[4] = 2
p[5] = 2

for i in range(6,101) : 
  p[i] = p[i-1] + p[i-5]

for i in range(T) : 
  x = int(input())
  print(p[x])
