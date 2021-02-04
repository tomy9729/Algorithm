#1149번 RGB거리 - 재귀함수 + 동적계획
import sys
sys.setrecursionlimit(10**6) 
n = int(input())
home = [0]*1001
color = [[0]*3 for i in range(1001)]
min_point = [[0]*3 for i in range(1001)]

for i in range(1,n+1) : 
  color[i] = list(map(int,input().split()))

def paint_home(x,color_num) : #x번째 집을 칠할 때
  global color
  global min_point
  if x == 1:
    return color[1][color_num]
  if color_num == 0 : 
    if min_point[x][0] == 0 : 
      min_point[x][0] = color[x][0] + min(paint_home(x-1,1),paint_home(x-1,2))
    return min_point[x][0]
  elif color_num == 1 : 
    if min_point[x][1] == 0 :
      min_point[x][1] = color[x][1] + min(paint_home(x-1,0),paint_home(x-1,2))
    return min_point[x][1]
  elif color_num == 2 : 
    if min_point[x][2] == 0:
      min_point[x][2] = color[x][2] + min(paint_home(x-1,0),paint_home(x-1,1))
    return min_point[x][2]

print(min(paint_home(n,0),paint_home(n,1),paint_home(n,2)))

#1149번 RGB거리 - 반복문 + 동적계획
n = int(input())
min_point = [[0]*3 for i in range(1001)] #최솟값

min_point[1] = list(map(int,input().split()))
for x in range(2,n+1) :
  r,g,b = map(int,input().split())
  min_point[x][0] = r + min(min_point[x-1][1],min_point[x-1][2]) # x번 째 집에 빨간색을 칠하는 경우
  min_point[x][1] = g + min(min_point[x-1][0],min_point[x-1][2]) # x번 째 집에 초록색을 칠하는 경우
  min_point[x][2] = b + min(min_point[x-1][0],min_point[x-1][1]) # x번 째 집에 파란색을 칠하는 경우

print(min(min_point[n]))
