#1021번 회전하는 큐
n,m = map(int,input().split())
result = list(map(int,input().split()))
deque = list(range(1,n+1))
count = 0

def left(d, r, i): # 2번 내용
  c = 0
  d = list(d)
  while d[0] != r[i] : 
    d.append(d[0])
    d.pop(0)
    c += 1
  d.pop(0)
  return d, c

def right(d, r, i): # 3번 내용
  c = 0
  d = list(d)
  while d[0] != r[i] : 
    d.insert(0,d[len(d)-1])
    d.pop()
    c += 1
  d.pop(0)
  return d, c

for i in range(m) :
  deque1, count1 = left(tuple(deque),result,i) # deque를 보존하기위해 tuple로 넘겨준다
  deque2, count2 = right(tuple(deque),result,i)
  if count1 < count2 : # count가 더 적은 것으로 결정
    deque = deque1
    count += count1
  else :
    deque = deque2
    count += count2

print(count)
