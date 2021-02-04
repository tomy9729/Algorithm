#1003번 피보나치 함수
fibonacci_arr = [0]*41

def fibonacci(n) :
  global count
  global fibonacci_arr
  if n == 0 :
    count[0] += 1 
    return 0
  elif n == 1 :
    count[1] += 1 
    return 1
  else : 
    if fibonacci_arr[n] == 0 : #불필요한 재귀함수를 막기 위함
      fibonacci_arr[n] = fibonacci(n-1) + fibonacci(n-2) #값을 배열에 저장함
    return fibonacci_arr[n]

count = [0]*2
T = int(input())
for i in range(T) :
  count[0] = 0
  count[1] = 0
  x = int(input())
  if x == 0 : 
    print("1 0")
  elif x == 1 :
    print("0 1")
  elif x == 2 :
    print("1 1")
  else :
    fibonacci(x)
    print("{} {}".format(fibonacci_arr[x-1],fibonacci_arr[x]))
