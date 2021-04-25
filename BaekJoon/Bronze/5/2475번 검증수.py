#2475번 검증수
if __name__ == "__main__":  
  nums = list(map(int,input().split()))
  result = 0
  for i in nums : 
    result += i**2
  print(result%10)
