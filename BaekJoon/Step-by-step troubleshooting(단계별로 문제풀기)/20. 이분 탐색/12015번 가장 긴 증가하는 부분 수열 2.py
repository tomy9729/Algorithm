#12015번 가장 긴 증가하는 부분 수열 2
def lower_bound(nums, num) : # 가장 먼저 나오는 num 이상인 수
  start = 0
  end = len(nums)-1
  
  while end > start : 
    mid = (start+end)//2
    if nums[mid] >= num : 
      end = mid 
    else :  
      start = mid + 1 
  return end
if __name__ == "__main__":
  n = int(input())
  a = list(map(int,input().split()))
  result = []
  result.append(a[0])
  for i in range(1,n) : 
    if result[-1] < a[i] : 
      result.append(a[i]) # result의 최댓값보다 크면 추가
    else :  # 같거나 작으면
      result[lower_bound(result,a[i])] = a[i] # result의 해당 값을 a[i]로 대체
  print(len(result))
