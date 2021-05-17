#7579번 앱
if __name__ == "__main__":  
  n,m = map(int,(input().split())) #n개의 앱, 필요한 메모리 m
  memory = list(map(int,input().split())) #n개의 앱들이 현재 사용 중인 메모리
  c = list(map(int,input().split()))#비활후 다시 활성화 했을 때 필요한 비용 c
  
  c_sum = sum(c)
  dp = [[0]*(c_sum+1) for i in range(n)] #
  for i in range(c_sum+1) : 
    if i >= c[0] : 
      dp[0][i] = memory[0]

  for i in range(1,n) : 
    for j in range(c_sum+1) : 
      if j < c[i] : 
        dp[i][j] = dp[i-1][j]
      else : 
        dp[i][j] = max(dp[i-1][j], memory[i]+dp[i-1][j-c[i]]) #현재 앱을 비활성화하는 경우와 현재 앱을 비활성화하지 않는 경우

  for i in range(c_sum+1) : 
    if dp[n-1][i] >= m : 
      print(i)
      break

# 현재 c 00 01 02 03 04 05 06 07 08 09 10  11  12  13  14  15 
# m  c 
# 30 3   00 00 00 30 30 30 30 30 30 30 30  30  30  30  30  30  최대 c만큼 비활성화가 가능하다고 했을 때 확보 가능한 최대 메모리
# 10 0   10 10 10 40 40 40 40 40 40 40 40  40  40  40  40  40
# 20 3   10 10 10 40 40 40 60 60 60 60 60  60  60  60  60  60
# 35 5   10 10 10 40 40 45 60 60 75 75 75  95  95  95  95  95
# 40 4   10 10 10 40 50 50 60 80 80 85 100 100 115 115 115 135 
