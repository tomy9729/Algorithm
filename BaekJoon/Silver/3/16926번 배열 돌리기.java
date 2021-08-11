//16926번 배열 돌리기.java
package com.ssafy.webex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 배열_돌리기_1_16926 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static String line;
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int R;
	static int[][] arr;
	
	static int[] dI = {0,1,0,-1};
	static int[] dJ = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		line = br.readLine();
		st = new StringTokenizer(line, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			line = br.readLine();
			st = new StringTokenizer(line, " ");
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int count = Math.min(M, N)/2;
		for(int r=0;r<R;r++) {
			for(int c=0;c<count;c++) {
				int i=c;
				int j=c;
				int start = arr[i][j];
				int d=0;
				while(d<4) {
					int nextI = i+dI[d];
					int nextJ = j+dJ[d];
					if(c <= nextI && nextI < N-c && c <= nextJ && nextJ < M-c) {
						arr[i][j]=arr[nextI][nextJ];
						i = nextI;
						j = nextJ;
					}
					else d++;
				}
				arr[c+1][c] = start;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(arr[i][j]+" ");
			}sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
