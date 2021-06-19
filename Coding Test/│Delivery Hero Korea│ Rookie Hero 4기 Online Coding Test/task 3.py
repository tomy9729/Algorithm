U = 2#3 
L = 3#2 
C = [0,0,1,1,2]#[2,1,1,0,1]

U = 3 
L = 2 
C = [2,1,1,0,1]

def solution(U, L, C):
    # write your code in Python 3.6
    first = [0]*len(C)
    second = [0]*len(C)
    for i in range(len(C)) : 
      if C[i] == 2 :
        first[i] = 1
        second[i] = 1
      elif C[i] == 1 :
        if sum(first) < U :
          first[i] = 1
        else : 
          second[i] = 1
    if sum(first)==U and sum(second)==L : 
      first = list(map(str,first))
      second = list(map(str,second))
      first = ''.join(first)
      second = ''.join(second)
      temp = first+","+second
      return temp
    else : 
      return "IMPOSSIBLE"

solution(U, L, C)
