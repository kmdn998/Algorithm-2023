import sys
input = sys.stdin.readline
a, k = map(int, input().split())
li= list(map(int, input().split()))

def insertion_sort(li):
    n = len(li)
    count = 0
    k_ = 0
    for i in range(1,n):
        newItem = li[i]
        loc = i-1
        while loc >= 0 and newItem < li[loc]:
            li[loc+1] = li[loc]
            loc -= 1
            count += 1
            if count == k:
                k_ = li[loc+1]
        li[loc+1] = newItem
        if loc + 1 != i:
            count += 1 
        if count == k:
            k_ = li[loc+1]

    if k>count:
        print(-1)
    else:
        print(k_)

insertion_sort(li)