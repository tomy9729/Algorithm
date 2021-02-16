#1676번 팩토리얼 0의 개수
n = int(input())
result = 0

for i in range(5,n+1,5) :
  if i%125 == 0 : 
    result += 3 
  elif i%25 == 0 : 
    result += 2 
  elif i%5 == 0 :
    result += 1 
print(result)
