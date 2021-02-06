#11047번 동전0
n,k = map(int,input().split())
coin = [0]*n
for i in range(n) : 
  coin[i] = int(input())
count = 0 # 필요한 동전의 개수

for i in range(n-1,-1,-1) : # 동전의 크기가 큰 것 부터 센다
  if coin[i] <= k : # 동전이 k보다 같거나 작으면
    temp = k//coin[i] # k를 동전으로 나눈 몫
    count += temp     # 만큼 count에 더하고
    k -= temp*coin[i] # 센 돈만큼 k에서 뺀다

print(count)
