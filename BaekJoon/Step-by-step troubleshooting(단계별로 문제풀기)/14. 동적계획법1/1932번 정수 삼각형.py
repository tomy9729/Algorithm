#1932번 정수 삼각형 - 재귀 + 동적계획
n = int(input())
triangle = [[0]*n for i in range(n)]
for i in range(n) :
  triangle[i] = list(map(int,input().split()))
max_point = [[0]*n for i in range(n)]

def select_num(floor, num) : 
  global triangle
  if max_point[floor][num] : 
    return max_point[floor][num]
  if floor == 0 : 
    max_point[floor][num] = triangle[floor][num]
    return max_point[floor][num] 
  if num == 0 : 
    max_point[floor][num] = triangle[floor][num] + select_num(floor-1,num)
    return max_point[floor][num]
  if num == floor :
    max_point[floor][num] = triangle[floor][num] + select_num(floor -1,num-1)
    return max_point[floor][num] 
  max_point[floor][num] = max(triangle[floor][num] + select_num(floor - 1, num-1),triangle[floor][num] + select_num(floor - 1 ,num))
  return max_point[floor][num]

result = []
for i in range(n) :
  result.append(select_num(n-1,i))
print(max(result))

#1932번 정수 삼각형 - 반복문 + 동적계획
n = int(input())
triangle = [[0]*n for i in range(n)]
for i in range(n) :
  triangle[i] = list(map(int,input().split()))
max_point = [[0]*n for i in range(n)]

max_point[0][0] = triangle[0][0]
for i in range(1,n) : 
  max_point[i][0] = triangle[i][0] + max_point[i-1][0]
  max_point[i][i] = triangle[i][i] + max_point[i-1][i-1]
  for j in range(1,i) : 
    max_point[i][j] = triangle[i][j] + max(max_point[i-1][j-1],max_point[i-1][j])

print(max(max_point[n-1]))
