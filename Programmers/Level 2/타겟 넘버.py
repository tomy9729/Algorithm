#Level 2 타겟 넘버.py
def solution(numbers, target):
    answer = 0
    def DFS(num, level) : 
        nonlocal answer
        if level == len(numbers) :
            if num == target : 
                answer += 1
            return
        if level == 1 : 
            DFS(num+numbers[level],level+1)
            DFS(num-numbers[level],level+1)
            DFS(-1*num+numbers[level],level+1)
            DFS(-1*num-numbers[level],level+1)
        else :
            DFS(num+numbers[level],level+1)
            DFS(num-numbers[level],level+1)
    DFS(numbers[0],1)
    return answer
