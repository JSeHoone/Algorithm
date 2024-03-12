import sys
t = int(sys.stdin.readline())

for i in range(1,t+1):
    num = sum(map(int,str(i)))
    total_num = i + num
    
    if total_num == t:
        print(i)
        break
    if i == t :
        print(0)