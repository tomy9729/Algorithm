#maps : 지도
#p : 공격력, 완전 내부 p, 반만 걸치면 p//2
#r : 범위
# y=x+1 y=x-1 y=-x+1 y=-x-1
#왼위 (-2,-2) 2사분면
#오위 (-2,-1) 1사분면
#왼아 (-1,-2) 3사분면
#오아 (-1,-1) 4사분면
def tri(x,y,r,qud,p,new_maps) : 
    if qud == 1 : 
        x -=2
        y -=1
        x_=-1
        y_=1
    elif qud == 2 : 
        x-=2
        y-=2
        x_=-1
        y_=-1
    elif qud == 3 : 
        x-=1
        y-=2
        x_=1
        y_=-1
    elif qud == 4 :
        x-=1
        y-=1
        x_=1
        y_=1
    count = 0
    for i in range(r) : 
        for j in range(r) : 
            if i<r-1 and j<r-1 : #r=3
                if new_maps[x+x_*i][y+y_*j] <= p :
                    count+=1
            elif (i+j) == r-1 and i>=1 and j>=1: 
                if new_maps[x+x_*i][y+y_*j] <= p/2 :
                    count+=1
    return count
def solution(maps, p, r):
    answer = 0
    new_maps = [[100]*(len(maps)+r) for i in range((len(maps)+r))]
    for i in range(r//2,(len(maps)+r//2)) : 
        for j in range(r//2,(len(maps)+r//2)) : 
            new_maps[i][j] = maps[i-r//2][j-r//2]
    
    n = len(maps)+2
    for i in range(r,n+r) : 
        for j in range(r,n+r) : 
            temp = 0
            temp += tri(i,j,r,1,p,new_maps)
            temp += tri(i,j,r,2,p,new_maps)
            temp += tri(i,j,r,3,p,new_maps)
            temp += tri(i,j,r,4,p,new_maps)
            if temp > answer : 
                answer = temp
    return answer

maps = [[1, 28, 41, 22, 25, 79, 4], [39, 20, 10, 17, 19, 18, 8], [21, 4, 13, 12, 9, 29, 19], [58, 1, 20, 5, 8, 16, 9], [5, 6, 15, 2, 39, 8, 29],[39, 7, 17, 5, 4, 49, 5], [74, 46, 8, 11, 25, 2, 11]]
p = 19
r = 6
print(solution(maps, p, r))
