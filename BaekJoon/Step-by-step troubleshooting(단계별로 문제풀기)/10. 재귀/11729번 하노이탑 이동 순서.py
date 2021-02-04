#11729번 하노이탑 이동 순서
n = int(input())
c = 0

def hanoi(n,s,d,v) : # n : 원판번호 s : 출발지 d : 도착지 v : 경유지
  if n == 1 : 
    print("{} {}".format(s,d)) 

  else : 
    hanoi(n-1,s,v,d)
    print("{} {}".format(s,d))
    hanoi(n-1,v,d,s)

def count(n) : 
  if n == 1 : return 1
  else : 
    return 2*count(n-1)+1
  
print(count(n))  
hanoi(n,1,3,2)
