#2630번 색종이 만들기
n = int(input())
color_paper = [[0]*n for i in range(n)]

for i in range(n) : 
  color_paper[i] = list(map(int,input().split()))

white_count = 0 #흰 색종이 세기
blue_count = 0 # 파란 색종이 세기

def make_color_paper(num,paper) : 
   global white_count
   global blue_count
   check = 0 # 색종이가 만들어지는 여부 확인
   for i in range(num) : 
     check += sum(paper[i]) #종이 전체가 섹종이가 되는지 확인하기 위해 총 합을 더함
   if check == 0 : # check가 0이라면 흰색종이
     white_count += 1
   elif check == num*num : # check가 num*num라면 파란 색종이
     blue_count += 1 
   else : # 색종이가 만들어지지 않을 경우
     temp = [paper[i][0:num//2] for i in range(0,num//2)]  # 4개로 나눠서 위 과정을 반복
     make_color_paper(num//2,temp)
     temp = [paper[i][0:num//2] for i in range(num//2,num)]
     make_color_paper(num//2,temp)
     temp = [paper[i][num//2:num] for i in range(0,num//2)]
     make_color_paper(num//2,temp)
     temp = [paper[i][num//2:num] for i in range(num//2,num)]
     make_color_paper(num//2,temp)

make_color_paper(n,color_paper)
print(white_count)
print(blue_count)
