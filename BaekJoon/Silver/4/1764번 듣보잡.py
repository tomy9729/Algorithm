#1764번 듣보잡
if __name__ == "__main__":
  n,m = map(int,input().split())
  no_hear = set([])
  no_see = set([])
  for i in range(n) : 
    no_hear.add(input())
  for i in range(m) : 
    no_see.add(input())
  result = []
  for i in no_hear : 
    if i in no_see : 
      result.append(i)
  result.sort()
  print(len(result))
  for i in result : 
    print(i)
