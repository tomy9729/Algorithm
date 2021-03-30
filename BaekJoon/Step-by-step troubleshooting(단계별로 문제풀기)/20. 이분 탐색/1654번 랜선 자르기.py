#1654번 랜선 자르기
def find_cm(nums, n) : # 정수 찾기
  start = 1
  end = max(nums)
  mid = (start + end)//2

  while start <= end : 
    len_count = sum([nums[i]//mid for i in range(len(nums))])
    if len_count >= n : # 찾고자 하는 값의 조건 : n보다 같거나 커야한다. 랜선의 길이가 최대가 되야하므로 mid 값을 올린다.
      start = mid + 1 
    else :              # len_count < n 이라면 n보다 크게 만들기 위해 mid 값을 내린다.
      end = mid - 1
    mid = (start + end)//2  # 위 조건에 맞춰 mid 재설정
  return mid

if __name__ == "__main__":
  k, n = map(int,input().split())
  lan = []
  for i in range(k) : 
    lan.append(int(input()))
  print(find_cm(lan,n))
