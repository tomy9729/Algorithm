#11401번 이항 계수
n,k = map(int,input().split())
mod = 1000000007

def fac(num) : 
  temp = 1
  for i in range(1,num+1) : 
    temp *= i
    if temp > mod : 
      temp %= mod
  return temp
  
def pow(num, square) :#분할정복, 제곱을 빠르게
  if square == 0 : 
    return 1
  elif square %2 == 0 : 
    return (pow(num,square//2)**2) %mod
  else : 
    return (pow(num,square//2)**2 * num) %mod

a = fac(n)%mod # 페르마의 소정리
b = pow(fac(k)%mod,mod-2)
c = pow(fac(n-k)%mod,mod-2)
result = a*b*c%mod

print(result)
