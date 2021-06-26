#1811번 마인크래프트
if __name__ == "__main__":
  n,m,b = map(int,input().split())
  land = [0]*257
  top = 0
  bot = 257
  for i in range(n) : 
    temp = list(map(int,input().split()))
    for j in temp : 
      land[j] += 1
      top = max(top, j)
      bot = min(bot, j)
  
  result_time = 9999999999999999
  result_height = 0
  for h in range(top,bot-1,-1) : 
    time = 0
    need = 0
    inven = b

    for now_block_h in range(bot,top+1) : 
      if land[now_block_h] == 0 :
        continue
      if now_block_h < h : 
        need += (h-now_block_h)*land[now_block_h]
        time += (h-now_block_h)*land[now_block_h]
      else : 
        inven += (now_block_h-h)*land[now_block_h]
        time += (now_block_h-h)*land[now_block_h]*2
    
    if need <= inven : 
      if result_time > time : 
        result_time = time
        result_height = h
  
  print("%d %d"%(result_time, result_height))

