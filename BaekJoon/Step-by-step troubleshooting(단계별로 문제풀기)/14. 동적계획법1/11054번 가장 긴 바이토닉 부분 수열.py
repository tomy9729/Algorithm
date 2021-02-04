#11054번 가장 긴 바이토닉 부분 수열
n = int(input())
arr_up = []
arr_down = []
arr_up = list(map(int,input().split())) #원래 수열 
arr_down = list(reversed(arr_up))  # 원래 수열을 뒤집음
length_up = [1]*n
length_down = [1]*n
length = []
for i in range(n) : 
  for j in range(i,n) : 
    if arr_up[i] < arr_up[j] : #원래 수열의 가장 긴 증가하는 부분 수열
      length_up[j] = max(length_up[i]+1,length_up[j])
    if arr_down[i] < arr_down[j] : #뒤집은 수열의 가장 긴 증가하는 부분 수열  == 원래 수열의 가장 긴 감소하는 부분 수열
      length_down[j] = max(length_down[i]+1, length_down[j])

for i in range(n) : 
  length.append(length_up[i] + list(reversed(length_down))[i]) # 각 인덱스마다 두 개 길이를 더해 줌

print(max(length)-1) # 인덱스는 중복되어 두번씩 세지기 때문에 하나를 뺌
