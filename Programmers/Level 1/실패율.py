#Level 1 실패율.py
def solution(N, stages):
    answer = []
    fail = [0]*N
    fail_percent = []
    for i in stages : 
        if i > N :
            continue
        fail[i-1] += 1 
    sum = len(stages)
    for i in fail :
        if sum == 0 :
            fail_percent.append(0)
        else : 
            fail_percent.append(i/sum)
        sum -= i
    for i in range(len(fail_percent)) : 
        answer.append(fail_percent.index(max(fail_percent))+1)
        fail_percent[fail_percent.index(max(fail_percent))]=-1
    return answer
