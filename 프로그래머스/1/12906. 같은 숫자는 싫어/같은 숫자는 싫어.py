def solution(arr):
    answer = []
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    answer.append(arr[0])
    for i in range(len(arr)-1):
        if arr[i] != arr[i+1]:
            answer.append(arr[i+1])
    return answer