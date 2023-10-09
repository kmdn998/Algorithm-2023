def merge_sort(L):
    if len(L) == 1:
        return L # 들어온 리스트 길이가 1일 때 L 반환
    mid = (len(L)+1)//2 # 리스트를 mid 기준 좌우로 나누기 위한 중간값
    
    #좌우로 나누어 재귀적 호출
    left = merge_sort(L[:mid])
    right = merge_sort(L[mid:])
    
    #좌우 인덱스 i,j 0으로 초기화
    i,j = 0,0
    #정렬된 요소 담을 리스트 선언
    sort_result = []
    
    #좌우 둘 다 요소 존재
    while i < len(left) and j < len(right):
        #좌우 요소 중 우가 더 클 때 좌 삽입
        if left[i] < right[j]:
            sort_result.append(left[i])
            bread.append(left[i])
            i+=1
        #좌우 요소 중 좌가 더 클 때 우 삽입
        else:
            sort_result.append(right[j])
            bread.append(right[j])
            j+=1
    #좌에만 요소 존재
    while i < len(left):
        sort_result.append(left[i])
        bread.append(left[i])
        i+=1
    #우에만 요소 존재
    while j < len(right):
        sort_result.append(right[j])
        bread.append(right[j])
        j+=1
    # 정렬된 리스트 리턴    
    return sort_result
    
#n, k 입력
n, k = map(int, input().split())
#정렬해야 할 리스트 입력
lt = list(map(int, input().split()))
#지정한 k가 몇 번째 저장되는지 확인용 리스트
bread = []
merge_sort(lt)

#k가 확인용 리스트에 저장된 길이보다 작거나 같을 경우 값 출력, 클 경우 -1 출력
if len(bread) >= k:
    print(bread[k - 1])
else:
    print(-1)
        