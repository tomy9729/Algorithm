def find_xy(double_array, val) : 
    x=0
    y=0
    for i in range(4) : 
        for j in range(3) : 
            if double_array[i][j] == val :
                x = i
                y = j
    return x,y

def absolute_value(num1, num2) : 
    if num1 > num2 : return num1-num2
    else : return num2 - num1
    
def solution(numbers, hand):
    answer = ''
    key_pad = [[1,2,3],
               [4,5,6],
               [7,8,9],
               ['*',0,'#']]
    left_location = '*'
    right_location = '#'
    
    for i in range(len(numbers)) : 
        if numbers[i] % 3 == 1 :
            answer += "L"
            left_location = numbers[i]
       
        elif numbers[i] % 3 == 2 or numbers[i] == 0 :
            l_loc = find_xy(key_pad,left_location)
            r_loc = find_xy(key_pad,right_location)
            put_loc = find_xy(key_pad,numbers[i])
            l_distance = absolute_value(l_loc[0],put_loc[0])+absolute_value(l_loc[1],put_loc[1])
            r_distance = absolute_value(r_loc[0],put_loc[0])+absolute_value(r_loc[1],put_loc[1])
            if ( l_distance > r_distance) : 
                answer += "R"
                right_location = numbers[i]
            elif (l_distance < r_distance) : 
                answer += "L"
                left_location = numbers[i]
            else : 
                if hand == "right" : 
                    answer += "R"
                    right_location = numbers[i]
                else : 
                    answer += "L"
                    left_location = numbers[i]
        elif numbers[i] % 3 == 0 :
            answer += "R"
            right_location = numbers[i]
                    
    
    return answer
