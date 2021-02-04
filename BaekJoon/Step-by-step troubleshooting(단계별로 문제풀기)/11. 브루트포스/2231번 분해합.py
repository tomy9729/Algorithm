#2231번 분해합
n = int(input())

for i in range(n) : 
  temp = i
  ans = i
  while temp > 0 : 
    ans += temp%10
    temp = temp//10

  if ans == n : 
    break
  
if i == n-1 : 
  print(0)
else : 
  print(i)
