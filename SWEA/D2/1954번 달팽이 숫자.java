//1954번 달팽이 숫자.java
package com.ssafy.daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달팽이_숫자_1954 {
	private static int T;
	private static int n;
	private static int[][] snail;
	private static int di[] = {0,1,0,-1};
	private static int dj[] = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			n = Integer.parseInt(br.readLine());
			snail = new int[n][n];
			int i=0;
			int j=0;
			int num=1;
			int d=0;
			for(int k=0;k<n;k++) {
				snail[i][j]=num;
				num++;
				i+=di[d%4];
				j+=dj[d%4]; 
			}
			i-=di[d%4];
			j-=dj[d%4]; 
			n--;
			
			while(n-- >0) {
				for(int k=0;k<2;k++) {
					d++;
					for(int dir=0;dir<=n;dir++) {
						i+=di[d%4];
						j+=dj[d%4]; 
						snail[i][j]=num;
						num++;
					}
				}
			}
			
			sb.append("#").append(t).append("\n");
			for(int a=0;a<snail.length;a++) {
				for(int b=0;b<snail[a].length;b++) {
					sb.append(snail[a][b]).append(" ");
				}sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
