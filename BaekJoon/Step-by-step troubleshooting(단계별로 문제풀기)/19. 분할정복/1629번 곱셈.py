#1629번 곱셉
a,b,c = map(int,input().split())
def rest(a,b,c) :
  if b == 1:
    return a%c
  elif b % 2 == 0 :
    temp = rest(a,b//2,c)
    return temp*temp%c
  else : 
    temp = rest(a,b//2,c)
    return a*temp*temp%c
    
print(rest(a,b,c))
