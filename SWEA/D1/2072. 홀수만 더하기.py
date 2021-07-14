#2072 홀수만 더하기
if __name__ == "__main__":
  t = int(input())
  for _ in range(t) : 
    answer = 0
    n = map(int,input().split())
    for num in n :
      if num%2 == 1 :
        answer += num
    print("#%d %d"%(_+1,answer))
