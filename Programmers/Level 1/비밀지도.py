#Level 1 비밀지도.py
def solution(n, arr1, arr2):
    answer = []
    map1 = num_to_map(n,arr1)
    map2 = num_to_map(n,arr2)
    map_result = []
    for i in range(n) : 
        temp = ""
        for j in range(n) : 
            if map1[i][j] == "1" or map2[i][j] == "1" :
                temp += "#"
            else : 
                temp += " "
        map_result.append(temp)
    return map_result

def num_to_map(n,arr) : 
    map_ = []
    for i in range(n) : 
        temp = bin(arr[i])[2:]
        while len(temp) < n : 
            temp = "0"+temp
        map_.append(temp)
    return map_
    
