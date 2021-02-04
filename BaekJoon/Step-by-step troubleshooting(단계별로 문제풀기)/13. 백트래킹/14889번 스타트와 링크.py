#14889번 스타트와 링크
from itertools import combinations
n = int(input())
s = [[0]*n for i in range(n)]
for i in range(n) : 
  s[i] = list(map(int,input().split()))

team1 = [0]*n
team2 = [0]*n

answers = [] #정답들의 집합

all = list(combinations(range(1,n+1),n//2)) #가능한 모든 조합

def team_point(team) : 
  point = 0
  for i in team : 
    for j in team : 
      point += s[i-1][j-1]
  return point 

for i in range(len(all)//2) : # 조합들의 반까지만 진행하여 한팀에, 나머지 반은 남은 팀으로 배정
  team1 = all[i]
  team2 = all[len(all)-1-i]
  answers.append((abs(team_point(team1)-team_point(team2)))) # 정답들에 추가

print(min(answers)) # 가능한 정답 중 최솟값 출력
