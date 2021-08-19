//1247. 최적 경로.java
package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최적_경로_1247 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class point{
		int i;
		int j;
		point(int i, int j){
			this.i=i;
			this.j=j;
		}
	}
	
	static int T;
	static int N;
	static point company;
	static point home;
	static point[] consumer;
	static int distance;
	static boolean[] visit;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			consumer = new point[N];
			st = new StringTokenizer(br.readLine()," ");
			company = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i=0;i<N;i++) {
				consumer[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			distance = 0;
			visit = new boolean[N];
			answer = Integer.MAX_VALUE;
			
			move(0,company);
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
	static void move(int cnt, point pre) {
		if(cnt==N) {
			distance+=Math.abs(pre.i-home.i)+Math.abs(pre.j-home.j);
			if(answer>distance)answer=distance;
			distance-=Math.abs(pre.i-home.i)+Math.abs(pre.j-home.j);
			return;
		}
		for(int n=0;n<N;n++) {
			if(visit[n]==false) {
				visit[n]=true;
				distance+=Math.abs(pre.i-consumer[n].i)+Math.abs(pre.j-consumer[n].j);
				if(distance<answer)move(cnt+1,consumer[n]);
				visit[n]=false;
				distance-=Math.abs(pre.i-consumer[n].i)+Math.abs(pre.j-consumer[n].j);
			}
		}
	}
}
