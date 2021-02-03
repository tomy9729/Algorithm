#1002번 터렛
n = int(input())

for i in range(n) : 
  x1,y1,r1,x2,y2,r2 = input().split()
  x1 = int(x1)
  y1 = int(y1)
  r1 = int(r1)

  x2 = int(x2)
  y2 = int(y2)
  r2 = int(r2)

  l = ((abs(x1-x2))**2 + (abs(y1-y2))**2)
  r = (r1+r2)**2
  r0 = (r1-r2)**2

  if l == 0 :
    if r1==r2: 
      print(-1) 
    else : 
     print(0)
  else : 
    if l == r or l == r0: 
      print(1)
    elif l > r or l < r0: 
      print(0)
    else : 
      print(2)
