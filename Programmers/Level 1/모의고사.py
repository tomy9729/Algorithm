#Level 1 모의고사
def solution(answers):
    supo = [0]*3
    supo_1 = [1,2,3,4,5]
    supo_2 = [2,1,2,3,2,4,2,5]
    supo_3 = [3,3,1,1,2,2,4,4,5,5]
    for i in range(len(answers)) : 
        if answers[i] == supo_1[i%5] : 
            supo[0] += 1
        if answers[i] == supo_2[i%8] : 
            supo[1] += 1
        if answers[i] == supo_3[i%10] : 
            supo[2] += 1
    max_num = max(supo)
    answer = []
    for i in range(3) : 
        if supo[i] == max_num : 
            answer.append(i+1)
    return answer
