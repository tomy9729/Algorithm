//1260번 DFS와 BFS.java
package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와_BFS_1260 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static List<Integer>[] point;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());//정점의 개수
		int M = Integer.parseInt(st.nextToken());//간선의 개수
		int V = Integer.parseInt(st.nextToken());
		
		point = new ArrayList[N+1];
		for(int i=1;i<=N;i++)point[i]=new ArrayList<Integer>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			point[from].add(to);
			point[to].add(from);
		}
		for(int i=1;i<=N;i++) {
			Collections.sort(point[i]);
		}
		
		boolean visit[] = new boolean[N+1];
		dfs(V,visit);
		sb.replace(sb.length()-1, sb.length(), "\n");
		
		visit = new boolean[N+1];
		bfs(V,visit);
		sb.replace(sb.length()-1, sb.length(), "");
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int start, boolean visit[]) {
		visit[start]=true;
		sb.append(start+" ");
		for(Integer next : point[start]) {
			if(!visit[next]) {
				dfs(next, visit);
			}
		}
	}
	
	public static void bfs(int start, boolean visit[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit[start]=true;
		q.add(start);
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now+" ");
			for(Integer next : point[now]) {
				if(!visit[next]) {
					visit[next]=true;
					q.add(next);
				}
			}
		}
	}
}
