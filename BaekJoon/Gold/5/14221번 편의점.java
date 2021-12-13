//14221번 편의점.java
package boj20211213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 편의점_14221 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int maxNum = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<edge>> graph = new ArrayList();
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<edge>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph.get(from).add(new edge(to, value));
			graph.get(to).add(new edge(from, value));
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int houseCount = Integer.parseInt(st.nextToken());
		int[] house = new int[houseCount];
		int cuCount = Integer.parseInt(st.nextToken());
		int[] cu = new int[cuCount];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<houseCount;i++) {
			house[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<cuCount;i++) {
			cu[i] = Integer.parseInt(st.nextToken());
		}
		
		int from=0;
		int dis=Integer.MAX_VALUE;
		
		for(int i=0;i<houseCount;i++) {
			int[] root = new int[N+1];
			Arrays.fill(root,Integer.MAX_VALUE);
			dijkstra(graph, root, house[i]);
			for(int j=0;j<cuCount;j++) {
				//도착 편의점 cu[j]
				//출발 집 house[i]
				if(dis > root[cu[j]] || (dis==root[cu[j]] && from > house[i])) {
					from = house[i];
					dis = root[cu[j]];
				}
			}
		}
		System.out.println(from);
	}
    
    static void dijkstra(ArrayList<ArrayList<edge>> graph,int[] root, int start) {
		root[start]=0;
		PriorityQueue<edge> pq = new PriorityQueue<>();
		pq.add(new edge(start,0));
		
		while(!pq.isEmpty()) {
			edge now = pq.poll();
			if(root[now.to] < now.value)continue;
			
			for(int i=0;i<graph.get(now.to).size();i++) {
				edge next = graph.get(now.to).get(i);
				if(now.value+next.value < root[next.to]) {
					root[next.to] = now.value+next.value;
					pq.add(new edge(next.to,root[next.to]));
				}
			}
		}
	}
    static class edge implements Comparable<edge>{
    	int to;
    	int value;
    	edge(int to, int value){
    		this.to=to;
    		this.value=value;
    	}
		@Override
		public int compareTo(edge o) {
			return Integer.compare(this.value, o.value);
		}
    }
}
