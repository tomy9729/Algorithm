#12865번 평범한 배낭
#import sys
#input = sys.stdin.readline
n,k = map(int,input().split())
wv = [[0]*2 for i in range(n+1)]
start = 98765  
bag = [[0]*(k+1) for i in range(n+1)]

for i in range(1,n+1) :
  wv[i] = list(map(int,input().split()))
  start = min(start,wv[i][0])
  for j in range(start,k+1) :
    if wv[i][0] <= j : 
      bag[i][j] = max(wv[i][1]+bag[i-1][j-wv[i][0]],bag[i-1][j])
    else : 
      bag[i][j] = bag[i-1][j]
print(bag[n][k])
