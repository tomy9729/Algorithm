#Level 1 다트 게임.py
def solution(dartResult):
    dartResult = list(dartResult) #list로 변환
    point = [] #각 점수 저장
    star = [] #*의 위치 저장
    sharp = [] # #의 위치 저장
    count = 0 #숫자 번호
    i = 0
    
    while i < len(dartResult)-1 : 
        if dartResult[i].isdigit() : #정수일 경우
            if dartResult[i]=="1" and dartResult[i+1]=="0": #10일 경우
                temp = 10
                i += 1
            else : 
                temp = int(dartResult[i])
                
            if dartResult[i+1] == "S" : #보너스만큼 계산
                temp = temp**1
            elif dartResult[i+1] == "D" : 
                temp = temp**2
            elif dartResult[i+1] == "T" : 
                temp = temp**3
            point.append(temp)
        if i+2 < len(dartResult) : 
            if dartResult[i+2] == "*" : #*일 경우
                star.append(count) #*의 위치 저장
                i += 3
            elif dartResult[i+2] == "#" : ##일경우
                sharp.append(count) ##의 위치 저장
                i += 3
            else : 
                i += 2
        else : 
            i += 2
        count += 1

    for i in range(len(star)) : #*옵션 적용
        if star[i] == 0 : 
            point[0] *= 2
        else : 
            point[star[i]] *=2
            point[star[i]-1] *= 2
    for i in range(len(sharp)) : ##옵션 적용
        point[sharp[i]] *= -1
    
    return sum(point)
