def solution(s):
    answer = []
    ss = s.replace('{{','').replace('}}','')
    ss = ss.split("},{")
    ss.sort(key=len)
    
    for i in range(len(ss))  :
        if i == 0 :
            answer.append(int(ss[0]))
        else : 
            a = ss[i].split(",") 
            b = ss[i-1].split(",") 
            for i in range(len(b)):
                a.remove(b[i])
            answer.append(int(a[0]))
    return answerx
