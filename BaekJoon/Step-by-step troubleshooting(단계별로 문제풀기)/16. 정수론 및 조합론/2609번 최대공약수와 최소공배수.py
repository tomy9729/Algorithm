#2609번 최대공약수와 최소공배수
a,b = map(int,input().split())

def factors(n) : #소인수분해
  factor = []
  while n != 1:
    for i in range(2,n+1) : 
      if n % i == 0 : 
        n = n//i
        factor.append(i)
        break 
  return factor

a_factor = factors(a)
b_factor = factors(b)

max_factor = 1 
for i in range(len(a_factor)) : 
  for j in range(len(b_factor)) : 
    if a_factor[i] == b_factor[j] : 
      max_factor *= a_factor[i]
      a_factor[i] = 0
      b_factor[j] = 0

print(max_factor)

min_multi = b * (a//max_factor)
print(min_multi)
