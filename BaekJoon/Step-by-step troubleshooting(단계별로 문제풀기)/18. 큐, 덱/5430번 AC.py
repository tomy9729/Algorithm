#5430번 AC
t = int(input())
for i in range(t) : 
  p = input()
  n = int(input())
  nums = input() #덱
  p = list(map(str,p.split("R"))) # R을 기준으로 문자열을 나눠줌
  if len(nums) == 2 : # 만약 빈 배열일 경우 따로 초기화
    nums = []
  else :
    nums = list(map(int,nums[1:-1].split(','))) # 입력받은 문자열을 괄호는 빼고 콤마를 기준으로 나눠줌
  front = 0 
  back = len(nums)-1
  error = 0

  for j in range(len(p)) : # R을 기준으로 나눈 p, 즉 D로만 구성되어 있음
    if j % 2 == 0 :
      front += len(p[j]) # 짝수번 째 D들은 front에 더해주고
    else : 
      back -= len(p[j]) # 홀수번 째 D들은 back에서 빼준다
    if back - front < -1 : #만약 배열이 비었는데도 삭제를 시도하면 에러처리함
      error = 1 
      break
  nums = nums[front:back+1]
  if len(p) % 2 == 0 : # R이 홀수 개라면 p의 길이는 짝수, R이 짝수 개라면 p의 길이는 홀수이다.
    nums = list(reversed(nums)) # p의 길이가 짝수라면 R은 홀수이므로 최종적으로 배열은 역순이 된다.
    
  if error == 1 :
    print("error")
  else :
    if len(nums) == 0 : #덱이 빈 경우
      print("[]")
    else :
      print("[%d"%nums[0],end='')
      for j in range(1,len(nums)) : 
        print(",%d"%nums[j],end='')
      print("]")
