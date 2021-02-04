#1436번 영화감독 숌
def is_end_num(num) : 
  num_list = []
  while num : 
    num_list.append(num%10)
    num = num//10
  for i in range(len(num_list)-2) : 
    if num_list[i] == 6 and num_list[i+1] == 6 and num_list[i+2] == 6 :
      return True

n = int(input())
count = 0  
num = 666

while count < n : 
  if is_end_num(num) : 
    count += 1
  num+=1
print(num-1)
