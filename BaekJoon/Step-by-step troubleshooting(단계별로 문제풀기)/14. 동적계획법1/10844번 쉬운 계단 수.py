#10844번 쉬운 계단 수
n = int(input())

step_num = [[0]*(10) for i in range(n+1)]
for i in range(1,10) : 
  step_num[1][i] = 1

for i in range(2,n+1) : 
  step_num[i][0] = step_num[i-1][1] # 1의 자리가 0인 수를 만드는 것은 1의 자리가 1인 수
  step_num[i][9] = step_num[i-1][8] # 1의 자리가 9인 수를 만드는 것은 1의 자리가 8인 수
  for j in range(1,9) : 
    step_num[i][j] = (step_num[i-1][j-1] + step_num[i-1][j+1])%1000000000 # 1의 자리가 j인 수를 만드는 것은 1의 자리가 j-1, j+1인 수

print(sum(step_num[n])%1000000000)
