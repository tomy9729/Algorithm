//1238번 파티.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_1238 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int maxNum = 1000001;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());//N명의 마을
		int M = Integer.parseInt(st.nextToken());//M개의 단방향도로
		int X = Integer.parseInt(st.nextToken());//모이는 마을 X - X번 마을을 출발점으로 생각
		
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
		
		//오고 가는데 드는 비용의 최댓값
		int[] allValue = new int[N+1];
		int[] root = new int[N+1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(root, maxNum);
			dijkstra(graph, root, i);
			allValue[i] += root[X];
		}
		
		Arrays.fill(root, maxNum);
		dijkstra(graph, root, X);
		for(int i=1;i<=N;i++) {
			allValue[i] += root[i];
		}
		
		Arrays.sort(allValue);
		System.out.println(allValue[N]);
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
