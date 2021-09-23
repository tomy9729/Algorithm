//1681. 해밀턴 순환회로.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 해밀턴_순환회로_1681 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st =  new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = Integer.MAX_VALUE;
		boolean[] visit = new boolean[N+1];
		dfs(1, 0, 0, map, visit);
		System.out.println(answer);
		
	}
	public static void dfs(int now, int count, int cost,int[][] map, boolean[] visit) {
		if(count == map.length-1) {
			if(now == 1) {
				if(answer > cost)answer = cost;
				return;
			}
			return;
		}
		if(cost > answer) {
			return;
		}
		for(int next=1;next<map.length;next++) {
			if(now!=next && !visit[next] && map[now][next]!=0) {
				visit[next] = true;
				dfs(next,count+1,cost+map[now][next],map,visit);
				visit[next] = false;
			}
		}
	}
}

/*
5
0 14 4 10 20
14 0 7 8 7
4 5 0 7 16
11 7 9 0 2
18 7 17 4 0
*/
