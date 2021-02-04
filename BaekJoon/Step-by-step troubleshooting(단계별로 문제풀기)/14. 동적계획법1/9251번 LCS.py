#9251번 LCS
string_1 = input()
string_2 = input()
arr = [[0]*(len(string_2)+1) for i in range(len(string_1)+1)]
#각 배열을 하나씩 증가하면서 LCS의 개수를 저장할 배열

for i in range(1,len(string_1)+1) : 
  for j in range(1,len(string_2)+1) : 
    if string_1[i-1] == string_2[j-1] : 
      arr[i][j] = arr[i-1][j-1]+1 # 두 문자가 같다면 이전까지 LCS길이에서 +1
    else :
      arr[i][j] = max(arr[i-1][j],arr[i][j-1]) # 두 문자가 다르다면 이전 LCS 중 가장 큰 값

print(max(arr[len(string_1)]))
