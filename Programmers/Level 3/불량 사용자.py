from itertools import product

def solution(user_id, banned_id):
    answer = 0
    ban_id = [[] for i in range(len(banned_id))]
    ban_num = []
    for i in range(len(banned_id)) : 
        ban_num.append(0)
    for i in range(len(user_id)) : 
        for j in range(len(banned_id)) : 
            for l in range(len(banned_id[j])):
                if len(user_id[i]) > l and len(user_id[i]) == len(banned_id[j]):
                    if user_id[i][l] == banned_id[j][l] : pass
                    elif banned_id[j][l] == '*' : pass
                    elif user_id[i][l] != banned_id[j][l] : break;
                        
                    if l == len(banned_id[j])-1 : 
                        ban_num[j] += 1
                        ban_id[j].append(user_id[i])
    max_ = 1
    for i in range(len(ban_num)):
        max_ *= ban_num[i]
    ban_id2 = set([frozenset(a) for a in product(*ban_id) if len(frozenset(a))==len(banned_id)])
    ban_id2 = list(ban_id2)
    answer = len(ban_id2)
    return answer
