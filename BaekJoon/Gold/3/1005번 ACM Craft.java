//1005번 ACM Craft.java
package boj20211214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft_1005 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] time = new int[N+1];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=1;i<=N;i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<ArrayList<Integer>> graph = new ArrayList();
			for(int i=0;i<=N;i++) {
				graph.add(new ArrayList<Integer>());
			}
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph.get(to).add(from);
			}
			int start = Integer.parseInt(br.readLine());
			int[] visit = new int[N+1];
			Arrays.fill(visit, -1);
			bfs(visit, start, time, graph);
			
			//System.out.println(Arrays.toString(visit));
			Arrays.sort(visit);
			sb.append(visit[N]+"\n");
		}
		System.out.println(sb.toString());
	}
    
    static void bfs(int[] visit, int start, int[] time, ArrayList<ArrayList<Integer>> graph) {
    	Queue<Integer> q = new LinkedList<Integer>();
    	visit[start] = time[start];
    	q.add(start);
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		for(int i=0;i<graph.get(now).size();i++) {
    			int next = graph.get(now).get(i);
    			if(visit[next]==-1 || visit[next] < visit[now]+time[next]) {
    				visit[next] = visit[now]+time[next];
    				q.add(next);
    			}
    		}
    	}
    }
}
