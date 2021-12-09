//11725번 트리의 부모 찾기.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의_부모_찾기_11725 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> graph = new ArrayList();
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		boolean[] visit = new boolean[N+1];
		int[] arr = new int[N+1];
		arr = bfs(visit, graph, arr);
		
		for(int i=2;i<=N;i++) {
			System.out.println(arr[i]);
		}
	}
	
	static int[] bfs(boolean[] visit, ArrayList<ArrayList<Integer>> graph, int[] arr) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			visit[now]=true;
			for(int i=0;i<graph.get(now).size();i++) {
				int next = graph.get(now).get(i);
				if(visit[next]==false) {
					arr[next]=now;
					q.add(next);
				}
			}
		}
		return arr;
	}
}
