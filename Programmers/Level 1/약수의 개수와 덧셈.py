#Level 1 약수의 개수와 덧셈.py
def solution(left, right):
    answer = 0
    for i in range(left,right+1) : 
        count = 0
        for l in range(1,i+1) :
            if i%l == 0 : 
                count += 1
        if count % 2 == 0 : 
            answer += i
        else : 
            answer -= i
    return answer
