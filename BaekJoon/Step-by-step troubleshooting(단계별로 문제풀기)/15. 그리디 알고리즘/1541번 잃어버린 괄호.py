#1541번 잃어버린 괄호
calculate = input().split('-') # -를 기준으로 분리 

def plus(cal) : # 중간 연산이 +일 때 계산
  cal = cal.split('+')
  temp = 0
  for i in range(len(cal)) : 
    temp += int(cal[i])
  return temp
result = 0

for i in range(len(calculate)) : # -기호라면 다음 +기호가 달린 모든 숫자에 괄호를 씌운다 -(a+b+c)
  if i == 0 : 
    result += plus(calculate[i])
  else : 
    result += -1*plus(calculate[i])
print(result)
