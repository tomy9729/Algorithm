#Level 2 기능개발.py
def solution(progresses, speeds):
    answer = []
    while len(progresses) : 
        for i in range(len(progresses)) : 
            progresses[i] += speeds[i]
        num = 0
        while True : 
            if len(progresses) == 0 : 
                break
            elif progresses[0] >= 100 : 
                num += 1
                progresses.pop(0)
                speeds.pop(0)
            else : 
                break
        if num!=0:
            answer.append(num)
    return answer
