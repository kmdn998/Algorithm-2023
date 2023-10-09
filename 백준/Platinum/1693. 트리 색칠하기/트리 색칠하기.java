import java.io.*;
import java.util.*;

public class Main {
	static int n, INF = 987654321;
	static List<Integer>[] list;
	static List<Integer>[] tree;
	static int[][] dp;

	static void createTree(int idx, int pa) {
		for (int value : list[idx]) { // idx = 1, pa = -1, value = 2
			if (value != pa) {
				tree[idx].add(value);
				createTree(value, idx); // idx = 2, pa = 1 루트는 1
			}
		}
	}

	static int coloring(int cur, int color) {
		if (dp[cur][color] != -1)
			return dp[cur][color];

		dp[cur][color] = 0;
		int cnt = 0;
		for (int next : tree[cur]) {
			int tmp = INF;
			for (int i = 1; i < 18; i++) {
				if (color != i) {
					tmp = Math.min(tmp, coloring(next, i));
				}
			}
			dp[cur][color] += tmp; //cur 노드의 서브트리들의 최소 비용의 합
		}
		return dp[cur][color] += color;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		tree = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		// list[1] = [2,3,4,5]
		// list[2] = [1] ...
		// list[5] = [6,7,8]

		createTree(1, -1);

		// tree[1] = [2,3,4,5]
		// tree[5] = [6,7,8]

		// 색과 트리 크기의 관계
		// T(N) : 트리에 N개의 색을 사용했을 때 나오는 트리의 최소 비용
		// minT(i) : T(i)의 최소 트리 크기
		
		//minT(1) = 1,
		//minT(2)= minT(1)+1 = 2,
		//minT(3)= minT(1)+minT(2)+1 = 4,
		//minT(4)= minT(1)+minT(2)+minT(3)+1 = 8

		// T(i) = min(T(1...i-1)) + 1 = (2^(i-1)-1) +1 = 2^(i-1)
		dp = new int[n + 1][18]; // max(i) = log2(100,000) = 16.60964... <17
		for (int i = 1; i < n + 1; i++) //루트는 어차피 1, 서브트리 최소 비용만 계산
			Arrays.fill(dp[i], -1); //임의로 -1 사용

		int result = INF;
		for (int c = 1; c < 18; c++)
			result = Math.min(result, coloring(1, c));

		System.out.println(result);
	}

}