def solution(numbers, hand):
    answer = ''
    left_button = [1,4,7,"*"]
    middle_button = [2,5,8,0]
    right_button = [3,6,9,"#"]
    
    l_position = '*'
    r_position = "#"
    
    for button in numbers:
        print(l_position, r_position)
        # only left
        if button in left_button:
            l_position = button
            answer += 'L'
        # only right
        elif button in right_button:
            r_position = button
            answer += 'R'
        # middle button
        else:
            if l_position in middle_button:
                L = abs(middle_button.index(l_position) - middle_button.index(button))
            else:
                L = abs(left_button.index(l_position) - middle_button.index(button)) + 1
                
            if r_position in middle_button:
                R = abs(middle_button.index(r_position) - middle_button.index(button))
            else:
                R = abs(right_button.index(r_position) - middle_button.index(button)) + 1
                
            if L < R :
                l_position = button
                answer += "L"
            elif L > R :
                r_position = button
                answer += 'R'
            else:
                if hand == "right":
                    r_position = button
                    answer += "R"
                else:
                    l_position = button
                    answer += 'L'
            
    return answer