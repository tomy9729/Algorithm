def solution(a, edges):
    answer = 0
    if sum(a) != 0 :
        return -1
    pri = [0]*len(a)
    for i in edges : 
        pri[i[0]] += 1
        pri[i[1]] += 1
        
    for i in edges : 
        if a[i[0]] == 0 or a[i[1]] == 0:
            continue
        elif pri[i[0]] >= pri[i[1]] : 
            if a[i[1]] > 0 :
                answer += a[i[1]]
                a[i[0]] += a[i[1]]
                a[i[1]] = 0
            else : 
                answer += abs(a[i[1]])
                a[i[0]] -= abs(a[i[1]])
                a[i[1]] = 0 
        else : 
            if a[i[0]] > 0 :
                answer += a[i[0]]
                a[i[1]] += a[i[0]]
                a[i[0]] = 0
            else : 
                answer += abs(a[i[0]])
                a[i[1]] -= abs(a[i[0]])
                a[i[0]] = 0   
    if max(a)!=0 : return -1
    return answer
