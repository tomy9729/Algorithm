#17219번 비밀번호 찾기
if __name__ == "__main__":
  n,m = map(int,input().split())
  program = {}
  for _ in range(n) :
    site,password = input().split()
    program[site] = password
  for _ in range(m) : 
    key = input()
    print(program[key])
