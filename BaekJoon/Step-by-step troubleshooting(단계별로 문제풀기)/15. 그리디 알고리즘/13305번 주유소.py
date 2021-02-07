#13305번 주유소
n = int(input())
distance = list(map(int,input().split()))
price = list(map(int,input().split()))

price_cheap = 1000000001 # 최대 기름값
result = 0
for i in range(n-1):
  if price_cheap > price[i] : # 현재까지 가장 싼 기름값
    price_cheap = price[i]
  result += price_cheap*distance[i] # 가장 싼 기름값 * 거리

print(result)
