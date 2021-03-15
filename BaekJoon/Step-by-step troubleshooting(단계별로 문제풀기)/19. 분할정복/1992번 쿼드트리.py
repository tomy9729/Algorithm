#1992번 쿼드트리
n = int(input())
quadtree = [[0]*n for i in range(n)]
for i in range(n) : 
  quadtree[i] = list(map(int,list(input())))

def video_compression(num, tree) :
  check = 0 # 압축 가능한지 불가능한지 여부 확인
  for i in range(num) : 
    check += sum(tree[i]) # 동영상의 모든 수의 합
  if check == 0 : 
    print(0,end='') # 0으로 압축 가능하면 0출력
  elif check == num*num : 
    print(1,end='') #1로 압축 가능하면 1 출력
  else: # 압축이 불가능하다면 4개로 나눔
    print('(',end='') # ( 출력
    temp = [tree[i][0:num//2] for i in range(0,num//2)] # 4개로 나눠서 순서대로 앞 과정 반복
    video_compression(num//2,temp)
    temp = [tree[i][num//2:num] for i in range(0,num//2)] 
    video_compression(num//2,temp)
    temp = [tree[i][0:num//2] for i in range(num//2,num)] 
    video_compression(num//2,temp)
    temp = [tree[i][num//2:num] for i in range(num//2,num)] 
    video_compression(num//2,temp)
    print(')',end='') # ) 출력

video_compression(n,quadtree)
