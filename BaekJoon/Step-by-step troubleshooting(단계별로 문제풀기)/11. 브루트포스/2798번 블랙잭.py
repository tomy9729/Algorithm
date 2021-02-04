#2798번 블랙잭
n,m = input().split()
n = int(n)
m = int(m)
nums = []
ans = 0

nums = input().split()

for i in range(n) : 
  nums[i] = int(nums[i])

for i in range(n) : 
  for j in range(i+1,n) : 
    for l in range(j+1,n) : 
      if nums[i]+nums[j]+nums[l] <= m and nums[i]+nums[j]+nums[l] > ans : 
        ans = nums[i]+nums[j]+nums[l]

print(ans)
