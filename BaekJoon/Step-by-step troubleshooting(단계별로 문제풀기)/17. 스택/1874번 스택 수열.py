#1874번 스택 수열
n = int(input())
stack = [] # 1~n까지 순서대로 push될 스택
pushpop = [] # push는+, pop은- 가 입력될 배열
nums = [] # 숫자들의 순서가 입력될 배열
num = 1 # 입력되는 숫자가 몇인지 저장
fail = 0 # 실패 시 1로 저장
for i in range(n):
  temp = int(input()) # i번 째에 입력되야할 배열의 숫자
  for j in range(num,temp+1) : # temp까지 스택에 push
    stack.append(j)
    pushpop.append('+')
    num += 1 # push할 때마다 입력되는 숫자 1씩 증가
  if stack[-1] == temp : # i번 째 입력되야할 배열의 숫자가 top이라면 pop
    stack.pop()
    pushpop.append('-')
  else : 
    fail = 1

if fail : 
  print('NO')
else:
  for i in range(len(pushpop)) : 
    print(pushpop[i])
