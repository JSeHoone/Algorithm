import sys

n = int(sys.stdin.readline())
 
data = [] 
ans = [] #
for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    data.append((a, b)) 
 
for i in range(n):
    count = 0
    for j in range(n):
        if data[i][0] < data[j][0] and data[i][1] < data[j][1]:
            count += 1 
    ans.append(count + 1) 
 
for d in ans:
    print(d,end=" ")