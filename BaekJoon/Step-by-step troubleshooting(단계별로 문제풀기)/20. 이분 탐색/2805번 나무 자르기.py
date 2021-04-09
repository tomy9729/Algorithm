#2805번 나무 자르기
def H(tree, m) : # H의 최댓값 구하기
  start = 1 #최소 높이
  end = max(tree) #최대 높이
  mid = (start + end)//2

  while start <= end : 
    log_len = 0 # 현재 잘라서 얻을 수 있는 나무의 길이 합
    for i in tree : 
      if i > mid : 
        log_len += i-mid
    if log_len >= m : # 길이 합이 m보다 같거나 크면
      start = mid + 1 # start를 높여서 H의 길이가 더 높도록 한다. 
    else : 
      end = mid - 1
    mid = (start+end)//2
  return mid
if __name__ == "__main__":
  n, m = map(int,input().split())
  tree = list(map(int,input().split())) 
  print(H(tree,m))
