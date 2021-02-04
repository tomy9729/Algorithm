#15652번 N과 M(4)
n,m = input().split()
n = int(n)
m = int(m)

arr = [0]*(m+1)

def check(x) :
  if x == m+1 : 
    for i in range(1,m+1) : 
      print(arr[i], end=' ')
    print()
  else : 
    for i in range(1,n+1) : 
      if max(arr) <= i : 
        arr[x] = i
        check(x+1)
        arr[x] = 0

check(1)
