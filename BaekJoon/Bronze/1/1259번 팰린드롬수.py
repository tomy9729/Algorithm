#1259번 팰린드롬수
def solve(n) : 
  n = list(str(n))
  length = len(n)
  for i in range(length//2) : 
    if n[i] != n[length-i-1] : 
      return False
  return True
if __name__ == "__main__":  
  while True : 
    n = int(input())
    if n == 0 : 
      break
    if solve(n) : 
      print("yes")
    else : 
      print("no")
