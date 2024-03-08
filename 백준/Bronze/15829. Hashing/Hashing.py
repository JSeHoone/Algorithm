import sys
_ = sys.stdin.readline()
word = sys.stdin.readline().strip()

total = 0
for index, i in enumerate(word):
    num = ord(i)-96
    total += (num * (31 ** (index)))

print(total % 1234567891)