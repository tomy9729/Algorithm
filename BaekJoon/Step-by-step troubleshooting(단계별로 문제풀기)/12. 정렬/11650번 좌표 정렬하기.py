#11650번 좌표 정렬하기
n = int(input())

xy = [[0]*2 for i in range(n)]

for i in range(n) :
  temp_x, temp_y = input().split()
  xy[i][0] = int(temp_x)
  xy[i][1] = int(temp_y)

result = sorted(xy, key = lambda x : (x[0],x[1]))  

for i in range(n) : 
  print("%d %d"%(result[i][0],result[i][1]))
