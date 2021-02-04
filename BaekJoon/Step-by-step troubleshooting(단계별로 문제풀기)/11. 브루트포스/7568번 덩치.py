#7568번 덩치
n = int(input())
weight = [0]*n
height = [0]*n
rank = [1]*n

for i in range(n) :
  weight[i],height[i] = input().split()
  weight[i] = int(weight[i])
  height[i] = int(height[i])
  rank[i] = 1

for i in range(n) : 
  for j in range(n) : 
    if weight[i] < weight[j] and height[i] < height[j] : 
      rank[i] += 1

for i in range(n) : 
  print(rank[i],end=' ')
