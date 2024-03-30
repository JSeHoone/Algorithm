import sys
n = int(sys.stdin.readline())
target = list(map(int, sys.stdin.readlines()))

number = 1
stack_ = [] # 여기에 들어가는 값이랑 빠지는 값이 print 되어야 하는 부분임
sequence_ =[]
make_ = True

index = 0
while (index+1 != n+1):
    # sequence가 비어있는 경우
    if (len(stack_) == 0):
        stack_.append(number)
        number += 1
        sequence_.append('+')

    # 스택에 들어가진 값이 target 값이랑 같다면 수열 리스트에 값을 넣어줌
    if (stack_[-1] == target[index]):
        stack_.pop()
        index += 1
        sequence_.append('-')
    
    # target값이랑 다르다면 stack에 더해줌
    else:
        stack_.append(number)
        number += 1
        sequence_.append('+')

    # if number over the n, this sequence dont make 
    if number > n+1:
        make_ = False
        break

if make_:
    print('\n'.join(str(i) for i in sequence_))
else:
    print('NO')