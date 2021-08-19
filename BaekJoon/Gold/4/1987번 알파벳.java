//1987번 알파벳.java
package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String line;
	
	static int R;
	static int C;
	static char[][] Alphabet;
	static boolean[] visit;
	static int dI[] = {0,0,1,-1};
	static int dJ[] = {1,-1,0,0};
	static int answer;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Alphabet = new char[R][C];
		visit = new boolean[26];
		for(int i=0;i<R;i++) {
			line = br.readLine();
			for(int j=0;j<C;j++) {
				Alphabet[i][j] = line.charAt(j);
			}
		}
		
		answer=0;
		visit[Alphabet[0][0]-65] = true;
		horseMove(0,0,1);
		System.out.println(answer);
	}
	
	public static void horseMove(int i, int j, int cnt) {
		answer = Math.max(answer, cnt);
		for(int d=0;d<4;d++) {
			int nextI = i+dI[d];
			int nextJ = j+dJ[d];
			if(0<= nextI && nextI < R && 0<= nextJ && nextJ < C) {
				if(visit[Alphabet[nextI][nextJ]-65]==false) {
					visit[Alphabet[nextI][nextJ]-65] = true;
					horseMove(nextI,nextJ,cnt+1);
					visit[Alphabet[nextI][nextJ]-65] = false;
				}
			}
		}
	}
}
