#Level 1 소수 만들기.py
from itertools import combinations
def solution(nums):
    answer = 0
    arr = [True]*(max(nums)*3+1) #에라토스테네스의 체를 저장한 배열
    arr[0] = False
    arr[1] = False 
    arr = is_prime_num(max(nums)*3,arr)#에라토스테네스의 체
    num_3 = list(combinations(nums,3)) #조합
    for i in range(len(num_3)) : 
        if arr[sum(num_3[i])] : 
            answer += 1
    return answer

def is_prime_num(n,arr) : 
    for i in range(2,n) : 
        j = 2 
        while i*j <= n : 
            l = i*j 
            arr[l] = False 
            j += 1
    return arr
