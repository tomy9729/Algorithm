#Level 1 로또의 최고 순위와 최저 순위.py
def solution(lottos, win_nums):
    answer = []
    count = 0 #이미 맞은 로또 개수
    count_0 = 0 #0의 개수
    for i in lottos : 
        if i == 0 : 
            count_0 += 1
        for j in win_nums : 
            if i == j :
                count += 1
    
    if count+count_0 == 0 or count+count_0 == 1 :
        answer.append(6)
    else : 
        answer.append(7-(count+count_0))
    if count == 0 or answer == 1 :
        answer.append(6)
    else : 
        answer.append(7-count)
    return answer
