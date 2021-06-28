#11723번 집합
#import sys
#input = sys.stdin.readline
if __name__ == "__main__":
  s = set([])
  n = int(input())
  for i in range(n) : 
    ins = input()
    if ins != 'all' and ins != 'empty' : 
      ins, x = ins.split()
      x = int(x) 
    
    if ins == 'add' : 
      if x not in s : 
        s.add(x)
    elif ins == 'remove' : 
      if x in s : 
        s.remove(x)
    elif ins == 'check' : 
      if x in s :
        print(1)
      else : 
        print(0)
    elif ins == 'toggle' : 
      if x in s : 
        s.remove(x)
      else : 
        s.add(x)
    elif ins == 'all' : 
      s = set([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20])
    elif ins == 'empty' : 
      s = set([])
