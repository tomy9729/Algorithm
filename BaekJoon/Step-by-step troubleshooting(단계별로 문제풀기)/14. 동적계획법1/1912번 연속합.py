#1912번 연속합
n = int(input())
num_arr = list(map(int,input().split()))
arr = [0]*n
arr[0] = num_arr[0]
for i in range(n) : 
  arr[i] = max(num_arr[i],arr[i-1]+num_arr[i]) #이전까지의 합이 음수라면 현재 수와 더하지 않고 새로 시작

print(max(arr))
