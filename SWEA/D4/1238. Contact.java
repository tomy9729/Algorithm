//1238. Contact.java
package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact_1238 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static List<Integer>[] people;// = new ArrayList[101];
	static int T;
	static int start;
	static int N;
	static int answer;
	static int visit[];
	static Queue<Integer> q;
	static int depth;
	static int nowDepth;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = 10;
		
		for(int t=1;t<=T;t++) {
			people = new ArrayList[101];
			for(int i=1;i<101;i++)people[i]=new ArrayList<Integer>();
			
			visit = new int[101];
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				people[from].add(to);
			}
			
			answer=0;
			depth=1;
			bfs(start);
//			int lastDepth = Arrays.stream(visit).max().getAsInt();
//			for(int i=1;i<101;i++) {
//				if(visit[i]==lastDepth) {
//					if(i>answer) {
//						answer=i;
//					}
//				}
//			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs(int start) {
		q = new LinkedList<Integer>();
		visit[start]=1;
		nowDepth=1;
		q.add(start);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(Integer next : people[now]) {
				if(visit[next]==0) {
					visit[next]=visit[now]+1;
					if(visit[next]>nowDepth) {
						nowDepth=visit[next];
						answer=next;
					}
					else if(visit[next]==nowDepth) {
						if(next>answer)answer=next;
					}
					q.add(next);
				}
			}
		}
	}
}
