#11049번 행렬 곱셈 순서
if __name__ == "__main__":  
  n = int(input())
  mat = [[0,0]]
  for i in range(n) : 
    a,b = map(int,input().split())
    mat.append([a,b])
  
  sums = [[0]*501 for i in range(501)]
  sum = [0]*501

  for dis in range(1,n) : 
    for start in range(n+1-dis) : 
      end = start + dis
      sums[start][end] = 999999999 
      for mid in range(start,end) : 
        sums[start][end] = min(sums[start][end],sums[start][mid]+sums[mid+1][end]+mat[start][0]*mat[mid][1]*mat[end][1]) 
  
  print(sums[1][n])
