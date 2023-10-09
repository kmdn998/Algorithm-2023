import sys

n, k = map(int, sys.stdin.readline().split()) #배열크기, 교환 횟수
nums = list(map(int, sys.stdin.readline().split())) #입력 배열

count = 0 #실제 교환 횟수 확인
answer = -1 #answer을 -1로 초기화 

for i in range(n-1, 0, -1): #배열의 크기--로 순회(역순 순회)
	for j in range(i): #j는 앞에서부터 배열의크기-1로 순회
		if nums[j] > nums[j+1]:  #앞이 뒤보다 크면 cont+, 순서 바꾸기
			count += 1
			nums[j], nums[j+1] = nums[j+1], nums[j]

			if count == k: #입력받은 교환 횟수만큼 교환하면 answer 변경
				answer = f'{nums[j]} {nums[j+1]}'	

print(answer)