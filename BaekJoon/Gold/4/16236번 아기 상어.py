#16236번 아기 상어
from collections import deque
def BFS(area,visit,baby_i,baby_j,baby_size,n) :
  eat_fish = []
  di = [0,0,1,-1]
  dj = [1,-1,0,0]
  visit[baby_i][baby_j] = True
  q = deque()
  q.append([baby_i,baby_j,0])
  while q :
    now = q.popleft()
    for index in range(4):
      next_i = now[0]+di[index]
      next_j = now[1]+dj[index]
      if 0<=next_i<n and 0<=next_j<n: #존재하는 배열이면
        if visit[next_i][next_j]==False and 0<= area[next_i][next_j] <= baby_size :#아직 방문하지 않은 점 and 아기 상어가 지나갈 수 있으면
          visit[next_i][next_j]=True # 방문
          q.append([next_i,next_j,now[2]+1]) #큐에 추가
          if 1<= area[next_i][next_j] < baby_size : #아기 상어가 먹을 수 있으면
            if (not eat_fish) or eat_fish[-1][2] == now[2]+1: # 최소 거리에 있는 모든 먹을 수 있는 물고기
              eat_fish.append([next_i,next_j,now[2]+1])
            else : return eat_fish # 최소 거리보다 더 멀리 있는 "먹을 수 있는 물고기"에 접근하면 종료
  return eat_fish #먹을 수 있는 물고기가 없으면 종료

if __name__ == "__main__":
  n = int(input())
  area=[]
  baby_i=0 #아기상어의 초기 위치
  baby_j=0
  baby_size=2 #아기 상어의 초기 크기
  baby_eat=0 #아기 상어가 먹은 물고기수
  for i in range(n) : 
    area.append(list(map(int,input().split())))
    for j in range(n) :
      if area[i][j]==9:
        baby_i=i
        baby_j=j
  visit = [[False]*n for _ in range(n)]
  time = 0 #시간

  while True : 
    visit = [[False]*n for _ in range(n)] #노드 방문 초기화
    fish = BFS(area,visit,baby_i,baby_j,baby_size,n)#아기 상어가 먹을 수 있는 물고기 후보군들
    area[baby_i][baby_j]=0 #아기 상어의 원래 위치 0으로 변환
    if not fish : #먹을 수 있는 물고기가 없으면 즉 엄마 상어를 불러야하면 종료
      break
    fish = sorted(fish,key=lambda x : (x[0],x[1])) #조건에 맞춰 물고기들 정렬
    fish = fish[0] #아기 상어가 먹은 물고기
    time += fish[2] #시간 추가
    area[fish[0]][fish[1]]=0 #아기 상어가 먹은 물고기의 위치 0으로 변환 (아기 상어가 먹었으므로)
    baby_i = fish[0] #아기상어의 위치 변환 (아기 상어가 먹은 물고기의 위치)
    baby_j = fish[1]
    area[baby_i][baby_j]=9 #아기 상어의 위치
    baby_eat+=1 # 아기 상어가 먹은 물고기 추가
    if baby_eat == baby_size : # 아기 상어가 자기 몸 크기만큼 물고기를 먹으면 아기 상어 크기 증가
      baby_size+=1
      baby_eat=0
  print(time)
