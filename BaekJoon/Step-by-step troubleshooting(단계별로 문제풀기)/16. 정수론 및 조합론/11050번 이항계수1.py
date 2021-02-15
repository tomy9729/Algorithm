#11050번 이항계수 1

n,k = map(int,input().split())
def fact(n) : # 팩토리얼을 통해 이항계수를 구한다
  if n > 0 : 
    return n*fact(n-1)
  else : 
    return 1

print(fact(n)//(fact(k)*fact(n-k))) # 이항계수 공식
