//2805. 농작물 수확학.java
package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 농작물_수확하기_2805 {
	private static int T;
	private static int N;
	private static int[][] farm;
	private static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			
			for(int i=0;i<N;i++) {
				String line = br.readLine();
				for(int j=0;j<N;j++) {
					farm[i][j]=line.charAt(j)-'0';
				}
			}
			
			answer = 0;			
			profit(0);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void profit(int n) {
		if(n>N/2)return;
		for(int i=N/2-n;i<N/2+n+1;i++) {
			answer += farm[n][i];
		}
		profit(n+1);
		if(n!=N/2) {
			for(int i=N/2-n;i<N/2+n+1;i++) {
				answer += farm[N-1-n][i];
			}
		}
		
	}
}
