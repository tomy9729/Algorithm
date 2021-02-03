#4153번 직각삼각형

while True : 
  x,y,z = input().split()
  x = int(x)
  y = int(y)
  z = int(z)
  
  if x == 0 and y == 0 and z == 0 : break

  l = sorted([x,y,z])
  if l[0]**2 + l[1]**2 == l[2]**2 : print("right")
  else : print("wrong")
