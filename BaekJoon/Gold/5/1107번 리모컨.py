#1107번 리모컨
if __name__ == "__main__":
  n = input()
  m = int(input())
  if m != 0 : 
    broken = set(map(int,input().split()))
  else : 
    broken = set()

  now = 100
  if int(n) == 100 : 
    print(0)
  elif m == 10 : 
    print(abs(int(n)-100))
  else :
    n = int(n)
    result = abs(int(n)-100)
    for i in range(1000001) : 
      num = set(map(int,list(str(i))))
      if num & broken == set() :
        if result > len(str(i)) + abs(n-i) : 
          result = len(str(i)) + abs(n-i)
    
    print(result)
