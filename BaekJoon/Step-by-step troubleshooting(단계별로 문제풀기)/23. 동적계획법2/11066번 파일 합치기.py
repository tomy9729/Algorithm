#11066번 파일 합치기
if __name__ == "__main__":  
  t = int(input())
  for i in range(t) : 
    sums = [[0]*501 for i in range(501)] # sums[i][j]는 i부터 j까지 합치는데 걸리는 최소 시간
    pre_sum = [0]*501 # 총합들

    k = int(input())
    files = list(map(int,input().split()))

    for l in range(len(files)) : 
      pre_sum[l] = pre_sum[l-1] + files[l]
    
    for page in range(1,k) : # page : start와 end의 거리
      for start in range(k+1-page) : # start : 시작
        end = start+page # end : 끝
        sums[start][end] = 9999999999
        pre = pre_sum[end]-pre_sum[start-1] # 
        for mid in range(start,end) : 
           sums[start][end] = min(sums[start][end],sums[start][mid]+sums[mid+1][end]+pre) # sums[i][j] = min(sums[i][mid]+sums[mid+1][j])
    print(sums[0][k-1])
