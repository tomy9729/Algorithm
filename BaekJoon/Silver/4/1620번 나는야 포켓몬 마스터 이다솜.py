#1620번 나는야 포켓몬 마스터 이다솜
if __name__ == "__main__":
  n,m = map(int,input().split())
  poketmon_num = {}
  poketmon_name = {}
  for i in range(1,n+1) : 
    name = input()
    poketmon_num[i] = name
    poketmon_name[name] = i
  for i in range(m) : 
    quiz = input()
    if quiz.isdigit() : 
      print(poketmon_num[int(quiz)])
    else : 
      print(poketmon_name[quiz])
