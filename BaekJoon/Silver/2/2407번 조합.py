#2407번 조합
def fac(num) : 
  f = 1
  for i in range(num,0,-1) :
    f *= i
  return f
if __name__ == "__main__":
  n,m = map(int,input().split())
  print((fac(n)//(fac(m)*fac(n-m))))
