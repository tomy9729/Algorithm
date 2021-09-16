//1263. 사람 네트워크2.java
package webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사람_네트워크2_1263 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[N+1][N+1];
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i==j) {
						st.nextToken();
						dp[i][j] = 0;
					}
					else {
						dp[i][j] = Integer.parseInt(st.nextToken());
						if(dp[i][j]==0)dp[i][j] = N*(N+1)/2;
					}
				}
			}
						
			for(int k=1;k<=N;k++) {
				for(int i=1;i<=N;i++) {
					for(int j=1;j<=N;j++) {
						dp[i][j] = Math.min((dp[i][k]+dp[k][j]),dp[i][j]);
					}
				}
			}
			
			
			int answer = N*(N+1)/2;
			for(int i=1;i<=N;i++) {
				int temp=0;
				for(int j=1;j<=N;j++) {
					temp += dp[i][j];
				}
				if(temp < answer)answer = temp;
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
}
