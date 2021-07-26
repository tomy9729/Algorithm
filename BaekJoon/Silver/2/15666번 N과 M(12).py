#15666번 N과 M(12)
def sol(depth) :
  if depth == m : 
    print(" ".join(map(str,arr)))
    return 

  for i in range(len(nums)):
    if depth == 0 or arr[-1]<=nums[i] : 
      arr.append(nums[i])
      sol(depth+1)
      arr.pop()

n,m = map(int,input().split())
nums = sorted(list(set(map(int,input().split()))))

arr= [] 
sol(0)




