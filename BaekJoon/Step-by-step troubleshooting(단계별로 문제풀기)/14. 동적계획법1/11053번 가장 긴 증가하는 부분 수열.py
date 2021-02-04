#11053번 가장 긴 증가하는 부분 수열
n = int(input())
arr = []
arr = list(map(int,input().split()))

length = []
sub_arr = [[] for i in range(n)]
bigger_than_this = [[] for i in range(n)]
for i in range(n) : 
  sub_arr[0].append([arr[i]])
  bigger_than_this[0].append([i])


for i in range(n) : # i는 부분수열의 길이
  for j in range(len(sub_arr[i])) : # sub_arr[i][j]는 각 부분수열들
    for l in range(max(bigger_than_this[i][j]),n) : 
      if max(sub_arr[i][j]) < arr[l] : 
        sub_arr[i+1].append(sub_arr[i][j] + [arr[l]])
        bigger_than_this[i+1].append([l])
        length.append(len(sub_arr[i+1][-1]))

print(max(length))
