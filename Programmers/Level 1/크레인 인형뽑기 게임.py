def solution(board, moves):
    basket = []
    answer = 0
    for i in range(len(moves)) : 
        for j in range(len(board)) : 
            if board[j][moves[i]-1] == 0 : continue
            else : 
                basket.append(board[j][moves[i]-1])
                board[j][moves[i]-1] = 0  
                break     
        if len(basket) > 1 :
            if basket[len(basket)-1] == basket[len(basket)-2] : 
                del basket[len(basket)-1] 
                del basket[len(basket)-1]
                answer += 2
    return answer
