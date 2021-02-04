#14888번 연산자 끼워넣기
import sys
input = sys.stdin.readline
n = int(input())
num = []
num = input().split()
for i in range(n) : 
  num[i] = int(num[i])

arr = [-1] * (n-1) # 연산자 기호들의 경우의 수를 그때그때 저장할 배열

operator = [0]*4
operator[0],operator[1],operator[2],operator[3] = map(int,input().split()) #순서대로 + - * /

all_operator = [] # 모든 연산자 기호들의 집합(중복 포함)
for i in range(4) : 
  for j in range(operator[i]) : 
    all_operator.append(i)
visit = [0]*len(all_operator) # 이미 사용된 기호를 구분하기 위함

def calculate(n1,n2,x) : # 연산자 계산기
  if x == 0 : 
    return n1+n2
  elif x == 1: 
    return n1-n2
  elif x == 2 :
    return n1*n2
  elif x == 3 :
    if n1 < 0 : 
      return -1*(-1*n1//n2)
    return n1//n2

def answer(num,arr) : # 완성된 식을 계산
  temp = num[0]
  for i in range(len(arr)) : 
    temp = calculate(temp,num[i+1],arr[i])
  return temp

answers = []
def check(x) :
  if x == n-1: # 끼워넣을 연산자 구성 완료
    answers.append(answer(num,arr))
  else : 
    for i in range(len(all_operator)) : 
      if visit[i] == 0 : # 중복 사용시 수행 x
        visit[i] = 1
        arr[x] = all_operator[i]
        check(x+1)
        arr[x] = -1
        visit[i] = 0

check(0)
print(max(answers))
print(min(answers))
