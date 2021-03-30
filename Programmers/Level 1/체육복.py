#Level 1 체육복
def solution(n, lost, reserve):
    delete = [] # lost와 resrve에서 중복으로 존재해서 삭제되는 학생들 저장
    for i in range(len(lost)) : 
        if lost[i] in reserve : 
            delete.append(lost[i])
            
    for i in range(len(delete)) : # 중복 학생 삭제
        lost.remove(delete[i])
        reserve.remove(delete[i])
    
    stu_num = n - len(lost) # 현재 수업을 들을 수 있는 학생 수
    
    for i in range(len(lost)) : 
        if lost[i]-1 in reserve : # 여벌을 빌릴 수 있으면 
            reserve.remove(lost[i]-1) # 여벌을 빌리고 reserve에서 빌려준 학생 삭제
            stu_num += 1 # 수업을 들을 수 있는 학생 수 추가
        elif lost[i]+1 in reserve : 
            reserve.remove(lost[i]+1)
            stu_num += 1
            
    answer = stu_num
    
    return answer
