import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, INF = 987654321;
	static List<Integer>[] list;
	static List<Integer>[] tree;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		tree = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st = null;
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		makeTreeData(1,-1);
		
		dp = new int[n+1][18];
		for(int i=1; i<n+1; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int res = INF;
		for(int c=1; c<18; c++) {
			res = Math.min(res, painting(1,c));		
		}
		System.out.println(res);
	}
    
	static int painting(int cur, int color) {
		if(dp[cur][color] != -1) return dp[cur][color];
		
		dp[cur][color]=0;
		int cnt =0;
		for(int nxt : tree[cur]) {
			int tmp = INF;
			for(int i=1; i<18; i++) {
				if(color!=i) {
					tmp = Math.min(tmp, painting(nxt,i));
				}
			}
			dp[cur][color] += tmp; 
		}
		return dp[cur][color] += color;
	}
	
	static void makeTreeData(int idx, int pa) {
		for(int nxt : list[idx]) {
			if(nxt != pa){
				tree[idx].add(nxt);
				makeTreeData(nxt ,idx);
			}
		}
	}
}