#3036번 링
n = int(input())
ring = []
ring = list(map(int,input().split()))

def euclidean(a,b) : 
  if b == 0 :
    return a
  else : 
    return  euclidean(b,a%b)

for i in range(1,n) : 
  temp = euclidean(ring[0],ring[i]) # 첫 번째 수와 i번 째수의 최대공약수
  print("%d/%d"%(ring[0]//temp,ring[i]//temp)) # 각 수를 최대공약수로 나눈 값으로 분수를 출력
