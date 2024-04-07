count = 0
max_ele = 0
max_len = 0
k, n = map(int, input().split())
lan = []

for i in range(k):
    lan.append(int(input()))

for i in range(k):
    if (max_ele < lan[i]):
        max_ele = lan[i]

start = 1
end = max_ele   

while (start <= end):
    mid = (start+end)//2

    for i in lan:
        count += i//mid
    
    if count >= n:
        max_len = mid
        start = mid + 1
    elif count < n:
        end = mid - 1
    count = 0

print(max_len)