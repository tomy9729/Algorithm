#10872번 팩토리얼
def fact(n) : 
  if n > 0 : 
    return n*fact(n-1)
  else : 
    return 1

n = int(input())
print(fact(n))
