#1931번 회의실 배정
n = int(input())
time = [[0]*2 for i in range(n)]

for i in range(n) : 
  time[i] = list(map(int,input().split()))

time = sorted(time, key = lambda x : (x[1], x[0])) # 끝나는 시간으로 1순위 오름차순 정렬, 시작하는 시간으로 2순위 오름차순 정렬

count = 1 # 첫 번째 배열에 있는 회의는 무조건 시작
end = time[0][1] # 회의가 끝나는 시간 저장

for i in range(1,n) : 
  if time[i][0] >= end : # 다음 회의의 시작시간이 지금 회의의 끝나는 시간과 같거나 늦으면
    count += 1  # 다음 회의로 진행
    end = time[i][1] # 회의가 끝나는 시간 저장

print(count)
