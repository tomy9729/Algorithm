//1916번 최소비용 구하기.java
package boj20211212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용_구하기_1916 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int maxNum = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
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
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		int[] root = new int[N+1];
		Arrays.fill(root, maxNum);
		dijkstra(graph, root, from);
//		System.out.println(Arrays.toString(root));
		System.out.println(root[to]);
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
