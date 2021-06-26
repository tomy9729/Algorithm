#1074번 Z
if __name__ == "__main__":
  n,r,c = map(int,input().split()) # 3 7 7 -> 63
  result = 0
  while n : 
    mid = 2**(n-1)
    if mid > r and mid > c : 
      result += 0
    elif mid > r and mid <= c : 
      result += mid*mid
      c -= mid
    elif mid <= r and mid > c : 
      result += mid*mid*2
      r -= mid
    elif mid <= r and mid <= c : 
      result += mid*mid*3
      c -= mid
      r -= mid
    
    n -= 1

  print(result+c+r)  
