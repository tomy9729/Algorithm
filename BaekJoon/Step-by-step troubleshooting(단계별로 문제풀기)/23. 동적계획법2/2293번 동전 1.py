#2293번 동전 1
if __name__ == "__main__":  
  n,k = map(int,input().split())
  coin = []
  for i in range(n) : 
    coin.append(int(input()))
  dp = [0]*10001
  dp[0]=1
  for c in coin : 
    for k_ in range(c,k+1) : 
      dp[k_] += dp[k_-c]
  print(dp[k])

  #c 
  #  1 2 3 4 5 6 7 8 9 10 k_
  #1 1 1 1 1 1 1 1 1 1 1
  #2 0 1 1 2 2 3 3 4 4 5
  #5 0 0 0 0 1 1 2 2 3 4
  #                    10
