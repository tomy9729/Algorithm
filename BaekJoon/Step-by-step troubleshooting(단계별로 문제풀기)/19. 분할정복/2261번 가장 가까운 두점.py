#2261번 가장 가까운 두점
def distance(point1, point2) : #두 점 사이의 거리
  return (point1[0]-point2[0])**2 + (point1[1]-point2[1])**2

def d_min(points) :
  n = len(points)
  if n == 2 :  #점이 2개 일 때
    return distance(points[0],points[1])
  if n == 3 : # 점이 3개 일 때
    return min(distance(points[0],points[1]),distance(points[0],points[2]),distance(points[1],points[2]))

  d = min(d_min(points[:n//2]),d_min(points[n//2:])) # 가운데 x좌표를 기준으로 양쪽으로 나눔
  
  check = [] # 최소 거리가 될 수 있는 후보 점들
  for p in points : 
    if (points[n//2][0]-p[0])**2 < d : # d보다 짧은 거리에 있는 점들만 후보로
      check.append(p)

  check = sorted(check, key = lambda x : x[1]) # y좌표로 정렬
  for i in range(len(check)-1) : 
    for j in range(i+1,len(check)) : 
      if (check[i][1]-check[j][1])**2 < d :  # y좌표 기준으로 d보다 짧은 거리에 있는 점들만
        d = min(d,distance(check[i],check[j])) # 확인   
      else : 
        break
  return d

#main
num = int(input())
point = []

for i in range(num) : 
  x,y = map(int,input().split())
  point.append([x,y])
  
point = sorted(point, key = lambda x : x[0])
d = d_min(point)
print(d)
