#1463번 1로 만들기
n = int(input())
count = 0
min_count = [0]*(n+1)
def cal(n, count) : #재귀함수로 풀 경우 Recursion error 발생, 해답이 나오긴한다.
  global min_count
  if min_count[n] : 
    return min_count[n]
  if n == 1 : 
    return count
  if n % 6 == 0 : 
    min_count[n] = min(cal(n//3,count+1),cal(n//2,count+1),cal(n-1,count+1))
    return  min_count[n]
  if n % 3 == 0 : 
    min_count[n] = min(cal(n//3,count+1),cal(n-1,count+1))
    return  min_count[n]
  if n % 2 == 0 :
    min_count[n] = min(cal(n//2, count+1),cal(n-1,count+1))
    return  min_count[n]
  min_count[n] = cal(n-1,count+1)
  return min_count[n]

min_count[1] = 0
for i in range(2,n+1) :
  if i % 6 == 0 : # 6의 배수일 때, 3으로 나눈 경우/2로 나눈 경우/1을 뺀 경우 중 최솟값
    min_count[i] = 1 + min(min_count[i//3],min_count[i//2],min_count[i-1]) 
    continue
  if i % 3 == 0 : # 3의 배수일 때, 3으로 나눈 경우/1을 뺀 경우 중 최솟값
    min_count[i] = 1 + min(min_count[i//3],min_count[i-1])
    continue
  if i % 2 == 0 : # 2의 배수 일 때, 2로 나눈 경우, 1을 뺀 경우 중 최솟값
    min_count[i] = 1 + min(min_count[i//2],min_count[i-1])
    continue
  min_count[i] = min_count[i-1] +1 # 2,3의 배수가 아닌경우 그냥 1을 뺀다

#print(cal(n,0))  # 재귀함수로 풀 경우 답 출력
print(min_count[n])
