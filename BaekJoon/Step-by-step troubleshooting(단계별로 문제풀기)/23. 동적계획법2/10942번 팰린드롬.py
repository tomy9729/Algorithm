#10942번 팰린드롬?
import sys
input = sys.stdin.readline
if __name__ == "__main__":  
  n = int(input())
  nums = list(map(int,input().split()))
  nums.insert(0,0)
  m = int(input())
  dp = [[-1]*(n+1) for i in range(n+1)]

  for dis in range(n) : 
    for start in range(1,n+1-dis) : 
      end = start + dis
      if start == end : 
        dp[start][end] = 1
      elif start+1 == end :
        if nums[start] == nums[end] : 
          dp[start][end] = 1
        else :
          dp[start][end] = 0
      else : 
        if nums[start] == nums[end] and dp[start+1][end-1] == 1 :
          dp[start][end] = 1
        else : 
          dp[start][end] = 0
  
  for i in range(m) : 
    start, end = map(int,input().split())
    print(dp[start][end])
