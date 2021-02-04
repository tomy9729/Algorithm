#10814번 나이순정렬
n = int(input())

user = [[0]*3 for i in range(n)]

for i in range(n) : 
  age,name = input().split()
  age = int(age)
  user[i][0] = age
  user[i][1] = name
  user[i][2] = i

user.sort(key=lambda x:(x[0],x[2]))

for i in range(n) : 
  print(user[i][0], end = ' ')
  print(user[i][1])
