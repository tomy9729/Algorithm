//1149번 RGB거리.java
package webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] RGB = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<3;j++)RGB[i][j]=Integer.parseInt(st.nextToken());
		}
		int[] rgb = new int[3];
		for(int i=1;i<=N;i++) {
			dp[i][0] = RGB[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = RGB[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = RGB[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		System.out.println(Math.min(dp[N][0],Math.min(dp[N][1],dp[N][2])));
	}
}

/*
3
26 40 83
49 60 57
13 89 99
*/
