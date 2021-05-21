#18870번 좌표 압축
if __name__ == "__main__":
  n = int(input())
  nums = list(map(int,input().split()))
  result = list(sorted(set(nums))) #set을 통해 중복 제거
  dic = {}
  for i in range(len(result)) : 
    dic[result[i]] = i #dictionary를 통해 각 숫자에 매칭되는 출력값 설정
  for i in nums : 
    print(dic[i],end = ' ')
