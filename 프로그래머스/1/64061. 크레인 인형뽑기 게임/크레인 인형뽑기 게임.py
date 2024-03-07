def solution(board, moves):
    answer = 0
    box = []
    
    for move in moves:
        target = move - 1 # target column
        for row in board:
            if row[target] != 0:
                box.append(row[target])
                row[target] = 0
                break
        if (len(box) >= 2) and (box[-1] == box[-2]):
            box.pop()
            box.pop()
            answer += 2

        
    return answer