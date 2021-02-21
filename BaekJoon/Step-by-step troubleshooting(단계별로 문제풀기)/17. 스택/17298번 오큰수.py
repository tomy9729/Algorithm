#17298번 오큰수
n = int(input())
nums = list(map(int,input().split()))
stack = []
nge = [0]*(n-1)
for i in range(n-1):
  if nums[i] < nums[i+1] : 
   nge[i] = nums[i+1] # 바로 오른쪽에 더 큰수가 있다면 바로 오큰수로 저장 
  else :
    stack.append(i) # 없다면 일단 스택에 저장, nums의 index를 저장
  while len(stack) and nums[stack[-1]] < nums[i+1] : # 스택이 존재하고 그 다음수가 오큰수일 때 
    nge[stack[-1]] = nums[i+1] # 오큰 수 저장
    stack.pop() # 스택에서 제거

while len(stack) : # 위 반복문을 다 돌고 나서도 스택에 남아있는 숫자들에 대해
  nge[stack[-1]] = -1 # 전부 -1로 오큰수 저장
  stack.pop()
for i in nge :
  print(i,end=' ')
print(-1)
