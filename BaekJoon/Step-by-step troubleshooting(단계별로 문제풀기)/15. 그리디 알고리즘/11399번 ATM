#11399번 ATM
n = int(input())
p = sorted(list(map(int,input().split()))) #입력받은 배열을 오름차순으로 정렬

result = 0
for i in range(n) : 
  result += p[i]*(n-i) #i번째 배열은 n-i번 곱한 만큼 더해진다.  

print(result)
