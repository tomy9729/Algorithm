#2629번 양팔저울
def btr(weight_count, weight_now) : 
  if dp[weight_count][weight_now] == 1 :
    return 
  else : 
    dp[weight_count][weight_now] = 1
  if weight_count >= n : 
    return
  
  btr(weight_count+1,weight_now+weight[weight_count]) # 추를 추가하고 구슬 없는 쪽에 놓는 경우
  btr(weight_count+1,weight_now) # 추를 추가했지만 아예 놓지 않는 경우
  btr(weight_count+1,abs(weight_now-weight[weight_count])) # 추를 추가하고 구슬 있는 쪽에 놓는 경우

if __name__ == "__main__":  
  n = int(input())
  weight = list(map(int,input().split()))
  bead_num = int(input())
  bead_weight = list(map(int,input().split()))
  dp = [[0]*(len(weight)*500+1) for i in range(len(weight)+1)]

  btr(0,0)
  
  for i in bead_weight : 
    if i > 15000 : # 구슬의 무게가 15000 초과하면 측정 불가능
      print("N",end=' ')
    elif dp[n][i] == 1 :
      print("Y",end=' ')
    else : 
      print("N",end=' ')
