#Level 2 더 맵게
import heapq
def solution(scoville, K):
    answer = 0
    scoville.sort()
    while scoville[0] < K : 
        if len(scoville) == 1 :
            return -1
        temp = heapq.heappop(scoville)
        temp += heapq.heappop(scoville)*2
        heapq.heappush(scoville,temp)
        answer += 1
    return answer
