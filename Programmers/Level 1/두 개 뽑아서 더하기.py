def insert_num(num, array) :     
    array.append(num)   
    for i in range(len(array)-1):
        if array[i] == array[len(array)-1] :
            del array[len(array)-1]
            break;
    return array        

    
def solution(numbers):
    answer = []
    for i in range(len(numbers)-1) :
        for j in range(i+1,len(numbers)):
            sum = numbers[i] + numbers[j]
            answer = insert_num(sum, answer)       
    answer.sort()
    return answer
