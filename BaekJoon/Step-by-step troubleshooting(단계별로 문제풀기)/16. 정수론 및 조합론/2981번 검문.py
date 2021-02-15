#2981번 검문
n = int(input())
num = []
for i in range(n) : 
  num.append(int(input()))

def euclidean(a,b) : 
  if b == 0 :
    return a
  else : 
    return  euclidean(b,a%b)

num = sorted(num)

max_factor = num[1]-num[0]  # 붙어 있는 항끼리 차를 구하고
for i in range(1,n-1) : 
  max_factor = euclidean(num[i+1]-num[i],max_factor)  # 모든 차에 대한 최대공약수를 구한다. 

m = [max_factor]
for i in range(2,int(max_factor**0.5)+1) : 
  if max_factor%i == 0 :
    m.append(i)
    if i != max_factor//i:
      m.append(max_factor//i)

m = sorted(m)
for i in m : 
  print(i,end=' ')
