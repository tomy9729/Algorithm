//3109번 빵집.java
package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집_3109 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String line;
		
	static int R;
	static int C;
	static char[][] road;
	static int dI[] = {-1,0,1};
	static int dJ[] = {1,1,1};
	static int answer;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		road = new char[R][C];
		answer=0;		
		for(int i=0;i<R;i++) {
			line = br.readLine();
			for(int j=0;j<C;j++) {
				road[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0;i<R;i++) {
			check=false;
			pipeLine(i,0);
		}
		System.out.println(answer);
	}
	
	static void pipeLine(int i, int j) {
		if(j==C-1) {
			answer++;
			check=true;
			return;
		}
		for(int d=0;d<3;d++) {
			int nextI = i+dI[d];
			int nextJ = j+dJ[d];
			if(0<= nextI && nextI<R && 0<=nextJ && nextJ < C) {
				if(road[nextI][nextJ]=='.') {
					if(check)return;
					road[nextI][nextJ]='o';
					pipeLine(nextI,nextJ);
				}
			}
		}
	}
}
