#Level 1 예산.py
def solution(d, budget):
    answer = 0
    while True : 
        if min(d) == 100001 : 
            break
        if min(d) <= budget : 
            budget -= min(d)
            answer += 1 
            d[d.index(min(d))] = 100001
        else : 
            break
    return answer
