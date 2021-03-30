#1920번 수 찾기
def bin_search(nums, num) : #이분탐색 리스트 nums, 찾고자 하는 값 num
  left = 0 # 가장 왼쪽
  right = len(nums)-1 # 가장 오른쪽
  mid = (left + right)//2  # 왼쪽과 오른쪽의 중앙

  while left <= right : # left > right인 동안 반복
    if nums[mid] < num : # mid값이 num보다 작으면
      left = mid+1      #left를 miod+1로
      mid = (left + right)//2
    elif nums[mid] > num : # mid값이 num보다 크면
      right = mid-1       #right를 mid-1로
      mid = (left + right)//2
    else : # 위 두조건을 다 만족하지 못하면 반복문 종료
      break 

  if nums[mid] == num : 
    return 1
  else : 
    return 0
 
if __name__ == "__main__":
  n = int(input())
  a = list(map(int,input().split()))
  a = sorted(a)

  m = int(input())
  b = list(map(int,input().split()))

  for i in range(m) : 
    print(bin_search(a,b[i]))
