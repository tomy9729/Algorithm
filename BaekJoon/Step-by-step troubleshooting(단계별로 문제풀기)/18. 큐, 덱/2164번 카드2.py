#2164번 카드2
n = int(input())
nums = [] #큐 
for i in range(n):
  nums.append(i+1)
front = 0 
back = n-1 

while back - front != 0 : # 큐의 길이가 1이 될 때까지
  front += 1 #맨 앞 숫자 삭제
  nums.append(nums[front]) # 맨 앞 숫자 맨 뒤로
  front += 1
  back += 1

print(nums[front])
