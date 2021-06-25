#9095번 1, 2, 3 더하기.py
if __name__ == "__main__":
  dp = [0]*12
  dp[0] = 1
  dp[1] = 2
  dp[2] = 4
  for i in range(3,12) : 
    dp[i] = dp[i-1]+dp[i-2]+dp[i-3]
  t = int(input())
  for i in range(t) : 
    n = int(input())
    print(dp[n-1])
