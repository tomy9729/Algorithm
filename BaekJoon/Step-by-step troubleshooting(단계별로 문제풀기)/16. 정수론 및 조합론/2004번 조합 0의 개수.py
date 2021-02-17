#2004번 조합 0의 개수
n,m = map(int,input().split())
n_5 = 0
m_5 = 0
n_m_5 = 0
n_2 = 0
m_2 = 0
n_m_2 = 0

# n!의 5의 개수
i = 1
while n >= 5**i : 
  n_5 += n // 5**i
  i += 1 
# m!의 5의 개수
i = 1
while m >= 5**i : 
  m_5 += m // 5**i
  i += 1  
# (n-m)!의 5의 개수
i = 1
while (n-m) >= 5**i : 
  n_m_5 += (n-m) // 5**i
  i += 1
# n!의 2의 개수
i = 1
while n >= 2**i : 
  n_2 += n // 2**i
  i += 1 
# m!의 2의 개수
i = 1
while m >= 2**i : 
  m_2 += m // 2**i
  i += 1  
# (n-m)!의 2의 개수
i = 1
while (n-m) >= 2**i : 
  n_m_2 += (n-m) // 2**i
  i += 1

five = n_5 - m_5 - n_m_5 # nCm 의 5의 개수
two = n_2 - m_2 - n_m_2 # nCm 의 2의 개수
print(min(two,five)) # 둘 중 더 작은거 출력
