#11727번 2xn 타일링2.py
if __name__ == "__main__":
  n = int(input())
  if n == 1 :
    print(1)
  else :
    dp = [0]*(n+1)
    dp[1] = 1
    dp[2] = 3
    for i in range(3,n+1):
      dp[i] = (dp[i-1]*dp[1]+dp[i-2]*(dp[2]-1))%10007
    print(dp[n])
