import sys
sys.setrecursionlimit(10**5)

# 노드 개수 입력받음
n = int(input())

# 부모 노드에서 자식 노드 방향으로만 추적을 진행할 것이니 방향 그래프로 생성해준다.
tree = [[] for _ in range(n + 1)]

# 트리의 지름
max_length = 0

# 트리 생성
for _ in range(n - 1):
    parent, child, weight = map(int, input().split())
    tree[parent].append((child, weight))

# DFS 통해 지름을 추적
# DFS로 리프 노드(최하단 노드)까지 내려간 뒤 해당 노드의 가중치를 리턴
# 그리고 자식 노드가 있는 부모 노드부터는 자식들의 경로들 중 가장 큰 두 것을 선택
# 더한 건 현재 노드를 기준으로 트리의 지름이 됨
# 어느 기준 노드의 지름이 가장 클지 알 수 없기 때문에 지름을 전역 변수로 하나 생성
# 더 큰 지름이 나올 때마다 갱신
# 상위 부모 노드로 갱신해 줄 때에는 왼쪽과 오른쪽 경로 중 더 큰 것을 리턴
def dfs(n, d):
    left, right = 0, 0
    for node, w in tree[n]:
        r = dfs(node, w)
        if left <= right:
            left = max(left, r)
        else:
            right = max(right, r)

    global max_length
    max_length = max(max_length, left + right)
    return max(left + d, right + d)

dfs(1, 0)
print(max_length)