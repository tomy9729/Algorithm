//1967번 트리의 지름.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의_지름_1967 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<edge>> graph = new ArrayList();
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<edge>());
		}
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph.get(from).add(new edge(to, value));
			graph.get(to).add(new edge(from, value));
		}
		int[] visit = new int[n+1];
		Arrays.fill(visit, -1);
		visit = bfs(visit, graph, 1);
		
		int max=0;
		int maxIndex=0;
		for(int i=0;i<=n;i++) {
			if(max < visit[i]) {
				max = visit[i];
				maxIndex = i;
			}
		}
		
		Arrays.fill(visit, -1);
		visit = bfs(visit, graph, maxIndex);
		for(int i=0;i<=n;i++) {
			if(max < visit[i]) {
				max = visit[i];
				maxIndex = i;
			}
		}
		System.out.println(max);
	}
    static int[] bfs(int[] visit, ArrayList<ArrayList<edge>> graph, int start) {
    	Queue<Integer> q = new LinkedList<Integer>();
    	visit[start]=0;
    	q.add(start);
    	
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		for(int i=0;i<graph.get(now).size();i++) {
    			edge next = graph.get(now).get(i);
    			if(visit[next.to]==-1) {
    				visit[next.to] = visit[now]+next.value;
    				q.add(next.to);
    			}
    		}
    	}
    	return visit;
    }
    
    static class edge{
    	int to;
    	int value;
    	edge(int to, int value){
    		this.to=to;
    		this.value=value;
    	}
    }
    
}
