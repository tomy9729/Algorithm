#11866번 요세푸스 문제 0
n,k = map(int,input().split())
nums = []
for i in range(n) : 
  nums.append(i+1)
result = []
front = 0
back = n-1

while back - front != -1 : # 본래는 원형큐로 푸는게 출제자의 의도인듯 하지만 귀찮아서 그냥 큐로 품
  for i in range(k-1) : #k만큼 앞에 있는 숫자를 뒤로 보냄
    nums.append(nums[front])
    front += 1
    back += 1
  result.append(nums[front]) #k번째마다 저장하고 큐에서 삭제
  front += 1

print("<",end='')
for i in range(n-1) : 
  print(result[i],end='')
  print(", ",end='')
print("%d>"%result[n-1])
