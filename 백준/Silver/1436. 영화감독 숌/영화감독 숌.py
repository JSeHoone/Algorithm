
list_ = [666,1666,2666,3666,4666,5666,6660,6661,6662,6663,6664,6665,6666,6667,6668,6669,7666,8666,9666]

import sys
num = sys.stdin.readline()



if int(num) <= 19:
    print(list_[int(num)-1] )

else:
    number = 10000
    count = 19
    while True:
        number += 1
        if '666' in str(number):
            count += 1
        
        if count == int(num):
            print(number)
            break