#1934번 최소공배수
n = int(input())

def euclidean(a,b) : 
  if b == 0 :
    return a
  else : 
    return  euclidean(b,a%b)

for i in range(n) : 
  a,b = map(int,input().split())
  max_factor = euclidean(a,b)
  min_multi = b * (a//max_factor)
  print(min_multi)
