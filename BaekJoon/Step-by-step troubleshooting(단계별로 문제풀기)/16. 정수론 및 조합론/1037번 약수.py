#1037번 약수
n = int(input())
factor = sorted(list(map(int,input().split())))

if len(factor) == 1 :
  print(factor[0]*factor[0])
else : 
  print(factor[0]*factor[len(factor)-1])
