#9375번 패션왕 신해빈
from itertools import combinations
t = int(input())
for i in range(t) : 
  n = int(input())
  cloth = []
  for j in range(n) : 
    name,kind = input().split()
    check = 0
    for l in range(len(cloth)) : 
      if cloth[l][0] == kind : 
        cloth[l][1] += 1 
        check = 1
    if check == 0 : 
      cloth.append([kind,1])
  result = 1
  for j in range(len(cloth)) : 
    result *= (cloth[j][1]+1)
  print(result-1)
