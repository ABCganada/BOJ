def prime(n):
    if n == 1:
        return 0
    for i in range(2, n):
        if n % i == 0:
            return 0
        
    return 1
    
N = int(input())

l = list(map(int, input().split()))

primeCnt = 0
for i in range(len(l)):
    if prime(l[i]):
        primeCnt += 1

print(primeCnt)
