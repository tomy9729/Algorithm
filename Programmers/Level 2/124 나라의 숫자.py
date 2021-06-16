#Level 2 124 나라의 숫자.py
def solution(n):
    answer = ''
    num = []
    while n != 0 : 
        if n%3 == 0 : 
            num.append("4")
            n = n//3 -1
        else : 
            num.append(str(n%3))
            n = n//3
    answer = "".join(reversed(num))
    return answer
