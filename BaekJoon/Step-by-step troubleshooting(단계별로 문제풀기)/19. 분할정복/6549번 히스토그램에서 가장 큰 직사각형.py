#6549번 히스토그램에서 가장 큰 직사각형
test_case = []
def current_rectangle(n,h) : #현재 다이어그램에서 가장 큰 직사각형 찾기
  if n%2 != 0 : # 가장 정중앙에 있는 다이어그램부터 시작하여 좌우로 넓혀가면서 직사각형의 크기를 측정
    left = n//2
    right = n//2
    height = h[left]
  else : 
    left = n//2 -1
    right = n//2 
    height = min(h[left],h[right])
  
  width = right-left+1
  area = height*width

  while left != 0 or right != n-1 : 
    if h[left-1] > h[right+1] : # 좌측에 있는 다이어그램이 더 크다면 좌측 다이어그램부터 고려
      left -= 1 
      height = min(height,h[left]) # 현재 높이와 새로 추가된 다이어그램의 높이 중 더 작은 값
      width = right-left+1 # 너비는 1추가
      area = max(area, height*width) # 넓이는 너비 x 높이
    else : # 우측에 있는 다이어그램이 더 크면 우측 다이어그램부터 고려
      right += 1
      height = min(height,h[right])
      width = right-left+1
      area = max(area, height*width)
    if left == 0 or right == n-1 : # 만약 어느 하나라도 끝에 도달했다면 반복문 종료
      break      
  while left != 0 : # 좌 또는 우의 끝에 도달하지 못했다면 도달할때까지 반복 수행     area = max(area, height*width) # 넓이는 너비 x 높이
      else : # 우측에 있는 다이어그램이 더 크면 우측 다이어그램부터 고려
            right += 1
                  height = min(height,h[right])
                        width = right-left+1
                              area = max(area, height*width)
                                  if left == 0 or right == n-1 : # 만약 어느 하나라도 끝에 도달했다면 반복문 종료
                                        break      
                                          while left != 0 : # 좌 또는 우의 끝에 도달하지 못했다면 도달할때까지 반복 수행
                                              left -= 1 
                                              
    left -= 1 
    height = min(height,h[left])
    width = right-left+1
    area = max(area, height*width)
  while right != n-1 : 
    right += 1
    height = min(height,h[right])
    width = right-left+1
    area = max(area, height*width)

  return area

def largest_rectangle(n,h) : #다이어그램을 절반으로 나누기
  if n == 1 :
    return h[0]
  mid = n//2
  devide_1 = h[:mid]
  devide_2 = h[mid:]
  if n % 2 == 0 : 
    result = max(current_rectangle(n,h),largest_rectangle(n//2,devide_1),largest_rectangle(n//2,devide_2)) 
    #현재 다이어그램에서의 가장 큰 직사각형, 현재 다이어그램을 두개로 나눈 두 다이어그램에서의 가장 큰 직사각형, 총 세개 중 가장 큰값
  else :
    result = max(current_rectangle(n,h),largest_rectangle(n//2,devide_1),largest_rectangle((n//2)+1,devide_2))

  return result

while True :
  test_case = list(map(int,input().split()))
  if test_case == [0] :
    break
  n = test_case[0]
  h = test_case[1:]
  print(largest_rectangle(n,h))
