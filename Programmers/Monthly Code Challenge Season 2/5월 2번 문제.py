def solution(numbers):
    answer = []
    for num in numbers : 
        n = num+1
        if (n & (n-1) == 0) and n != 0 : 
            answer.append((n*2-1)-(n//2))
            continue
        
        bin_num = list(bin(num))
        if bin_num[-1] == "0" :
            bin_num[-1] = "1"
        else : 
            for i in range(len(bin_num)-2,-1,-1) : 
                if bin_num[i] == "0" : 
                    bin_num[i] = "1"
                    bin_num[i+1] = "0"
                    break
        
        answer.append(int(''.join(bin_num),2))
                
    return answer
