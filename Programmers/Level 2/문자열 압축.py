#Level 2 문자열 압축.py
def solution(s):
    answer = 0
    def compact(n) : 
        s_ = list(s)
        result = ""
        while s_ : 
            num = 1
            if len(s_) > n :
                temp = s_[:n]
                s_ = s_[n:]
            else : 
                temp = s_
                s_ = []
            while temp == s_[:n] : 
                num += 1
                s_ = s_[n:]
            if num == 1 : 
                result += "".join(temp)
            else : 
                result += str(num) + "".join(temp)
        return len(result)
    
    answer = compact(1)
    for i in range(2,len(s)+1) : 
        temp = compact(i)
        if answer > temp : 
            answer = temp
    return answer
    
