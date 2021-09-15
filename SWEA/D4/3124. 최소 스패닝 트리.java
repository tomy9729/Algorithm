//3124. 최소 스패닝 트리.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소_스패닝_트리_3124 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T =  Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			long answer=0;
			int count=0;
			st =  new StringTokenizer(br.readLine()," ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			ArrayList<ArrayList<edge>> graph = new ArrayList<ArrayList<edge>>();
			for(int i=0; i<V+1; i++) {
				graph.add(new ArrayList<edge>());
	        }

			for(int e=0;e<E;e++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(new edge(b,c));
				graph.get(b).add(new edge(a,c));
			}
			
			PriorityQueue<edge> pq = new PriorityQueue<edge>();
			boolean[] visit = new boolean[V+1];
			pq.add(new edge(1, 0));
			while(!pq.isEmpty()) {
				edge edge = pq.poll();
				if(visit[edge.dest])continue;
				visit[edge.dest] = true;
				answer += edge.w;
				count++;
				if(count==V)break;
				
				for(edge next : graph.get(edge.dest)) {
					if(visit[next.dest])continue;
					pq.add(next);
				}
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
	static class edge implements Comparable<edge>{
		int dest;
		int w;
		edge(int dest, int w) {
			this.dest = dest;
			this.w = w;
		}
		
		@Override
		public int compareTo(edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
}
