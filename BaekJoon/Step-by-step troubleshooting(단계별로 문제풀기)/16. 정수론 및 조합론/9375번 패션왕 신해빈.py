#9375번 패션왕 신해빈
from itertools import combinations
t = int(input())
for i in range(t) : # 모든 테스트 케이스에 대해
  n = int(input())
  cloth = []
  for j in range(n) : # 모든 옷, 종류에 대해
    name,kind = input().split()
    check = 0 # 이미 존재하는 종류인지 여부
    for l in range(len(cloth)) : 
      if cloth[l][0] == kind : # 이미 존재하는 종류의 옷이라면
        cloth[l][1] += 1 # 종류 하나 추가
        check = 1 # 이미 존재하는 옷이라고 표시
    if check == 0 : # 새로운 종류의 옷이라면
      cloth.append([kind,1]) # 종류 추가
  result = 1
  for j in range(len(cloth)) : 
    result *= (cloth[j][1]+1) # 모든 종류의 옷의 개수 +1만큼 전부 곱한 후
  print(result-1) # 아무것도 안입는 경우 1 빼고 
