#10816번 숫자 카드2
#import sys
#input = sys.stdin.readline
def lower_bound(nums, num) : # num보다 작은 수 중 제일 큰 값 찾기
  start = 0
  end = len(nums)-1
  
  while end > start : # end가 start와 같거나 작으면 종료
    mid = (start+end)//2
    if nums[mid] >= num : # 중앙값이 num보다 같거나 크면
      end = mid # end를 mid로
    else :  # 중앙값이 num보다 작으면
      start = mid + 1 #start를 mid+1로
  return end

def upped_bound(nums, num) : # num보다 큰 수 중 가장 큰 값 찾기
  start = 0
  end = len(nums)-1

  while end > start : 
    mid = (start+end)//2
    if nums[mid] > num :
      end = mid
    else :
      start = mid + 1
  return end

if __name__ == "__main__":
  n = int(input())
  card = list(map(int, input().split()))
  card = sorted(card)
  m = int(input())
  check_card = list(map(int, input().split()))
  for i in range(m) : 
    count = upped_bound(card,check_card[i])-lower_bound(card,check_card[i])
    if check_card[i] == card[n-1] : # 가장 큰 값이 배열 끝에 있는 경우 upperbound는 실제값보다 1작게 나온다. 배열의 크기보다 커질수 없기 때문
      count += 1 
    print(count,end=' ')
