K = int(input())
BNum = list(map(int, input().split()))
tree = [[] for _ in range(K)] # K개의 빈 리스트를 포함하는 2차원 리스트
 
 
def makeTree(arr, x): #빌딩 방문 순서, 노드 깊이 
    mid = (len(arr)//2) #몫이 맨 위 노드(부모 노드)
    tree[x].append(arr[mid]) #0번째 깊이에 mid 넣기
    if len(arr) == 1:
        return #입력받은 방문 빌딩이 1개면 return 
    makeTree(arr[:mid], x+1) #mid 앞의 것들 반복해서 진행
    makeTree(arr[mid+1:], x+1) #mid 뒤의 것들 반복해서 진행
 
 
makeTree(BNum, 0)
for i in range(K):
    print(*tree[i]) #[]이거 없이 개별인자들 출력
    