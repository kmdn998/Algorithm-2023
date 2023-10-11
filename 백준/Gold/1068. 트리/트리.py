# 트리의 노드의 개수
n = int(input())

# 0번 노드부터 N-1번 노드까지, 각 노드의 부모
arr = list(map(int, str(input()).split(" ")))

# 지우려는 노드
remove_node = int(input())

def dfs(delete, arr):

    # 현재 노드는 지워야하는 노드이므로, -2로 변환
    arr[delete] = -2

    for i in range(n):

        # 지워야하는 노드를 부모로 둔 자식 노드일 경우, 자식 노드를 -2로 변환
        if (arr[i] == delete):
            dfs(i, arr)

# 각 노드의 부모 배열을 탐색하며,
# 지워야하는 노드와 해당 노드가 부모 노드인 자식 노드들의 값들을 모두 특정 값(-2)으로 변환
dfs(remove_node, arr)

# 리프 노드의 개수
leaf = 0

# 각 노드의 부모 배열을 다시 한 번 탐색
for i in range(n):

    # 값이 -2 가 아니며, 
    if (arr[i] != -2):

        # 해당 노드를 부모로 하는 노드가 부모 배열에 없을 경우, 
        if (i not in arr):

            # 리프 노드의 개수를 +1
            leaf += 1

print(leaf)
