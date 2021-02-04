#9184번 신나는 함수 실행
abc = [[[0]*21 for i in range(21)] for j in range(21)]

def w(a,b,c) : 
  if a <= 0 or b <= 0 or c <= 0 :
    return 1
  if a > 20 or b > 20 or c > 20 :
    if abc[20][20][20] == 0 :  
      abc[20][20][20] = w(20,20,20)
    return abc[20][20][20]

  if abc[a][b][c] :
    return abc[a][b][c]
  if a < b and b < c : 
    abc[a][b][c] =  w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c)
    return abc[a][b][c]

  abc[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1)
  return abc[a][b][c]

while True :
  a,b,c = map(int,input().split())
  if a == -1 and b == -1 and c == -1 : 
    break
  print("w(%d, %d, %d) = %d"%(a,b,c,w(a,b,c)))
