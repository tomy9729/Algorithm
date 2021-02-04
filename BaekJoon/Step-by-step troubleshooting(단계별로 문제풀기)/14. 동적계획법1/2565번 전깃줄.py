#2565번 전깃줄
n = int(input())

line = []
for i in range(n) : 
  line.append(list(map(int,input().split())))
line_count = [1]*n

line.sort(key = lambda x : x[0])

for i in range(n) : 
  for j in range(i) : 
    if line[i][1] > line[j][1] : 
      line_count[i] = max(line_count[i],line_count[j]+1)

print(n-max(line_count))
