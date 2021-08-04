//1873번 상호의 배틀 필드.java
package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의_배틀필드_1873 {
	private static int T;
	private static int H;
	private static int W;
	private static char[][] map;
	private static int N;
	private static int tankI;
	private static int tankJ;
	private static int tankD;
	private static int[] di = {-1,1,0,0};
	private static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line," ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for(int i=0;i<H;i++) {
				line = br.readLine();
				for(int j=0;j<W;j++) {
					map[i][j]=line.charAt(j);
					switch(map[i][j]) {
						case '^' : 
							tankI=i;
							tankJ=j;
							tankD=0;
							break;
						case 'v' : 
							tankI=i;
							tankJ=j;
							tankD=1;
							break;
						case '<' : 
							tankI=i;
							tankJ=j;
							tankD=2;
							break;
						case '>' : 
							tankI=i;
							tankJ=j;
							tankD=3;
							break;
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			for(int i=0;i<N;i++) {
				tankMove(input.charAt(i));
			}
			
			if(tankD==0)map[tankI][tankJ]='^';
			else if(tankD==1)map[tankI][tankJ]='v';
			else if(tankD==2)map[tankI][tankJ]='<';
			else if(tankD==3)map[tankI][tankJ]='>';
			
			
			sb.append("#").append(t).append(" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					sb.append(map[i][j]);
				}sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void tankMove(char in) {
		int nextI;
		int nextJ;
		if(in=='U') tankD=0;
		else if(in=='D') tankD=1;
		else if(in=='L') tankD=2;
		else if(in=='R') tankD=3;
		
		if(in != 'S') {
			nextI = tankI+di[tankD];
			nextJ = tankJ+dj[tankD];
			if(inMap(nextI,nextJ)) {
				if(map[nextI][nextJ]=='.') {
					map[tankI][tankJ]='.';
					tankI=nextI;
					tankJ=nextJ;
				}
			}
		}
		
		else {
			int bombI=tankI;
			int bombJ=tankJ;
			
			while(true) {
				bombI += di[tankD];
				bombJ += dj[tankD];
				if(inMap(bombI, bombJ)) {
					if(map[bombI][bombJ]=='*') {
						map[bombI][bombJ]='.';
						break;
					}
					if(map[bombI][bombJ]=='#')break;
				}
				else break;
			}
		}
		
	}
	public static boolean inMap(int i, int j) {
		if(0<=i && i<H && 0<=j && j<W)return true;
		else return false;
	}
}
