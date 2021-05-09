#리프트에 손님을 탑승
#기준 : 도착시간 + 티켓등급
# t : 도착한시간, 리프트번호
# r : 티켓 등급
def solution(t, r):
    guest_num = len(t)
    answer = []
    tr = []
    for i in range(len(t)) : 
        tr.append([t[i],r[i],i])
        
    lift = []
    count = 0 
    time = 0
    while count < guest_num : 
        for i in range(guest_num) : 
            if tr[i][0] == time : 
                lift.append(tr[i])
        lift = sorted(lift, key = lambda x : (x[1],x[0],x[2]))
        if lift
        answer.append(lift.pop(0)[2])
        count += 1
        time += 1
    return answer

#t = [0,1,3,0]
#r = [0,1,2,3]
t = [7,6,8,1]
r = [0,1,2,3]
print(solution(t,r))
