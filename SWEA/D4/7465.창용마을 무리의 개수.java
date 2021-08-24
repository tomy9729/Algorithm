//7465.창용마을 무리의 개수.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 창용마을_무리의_개수_7465 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int answer;
    static List<Integer>[] people;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			people = new ArrayList[N+1];
			for(int i=1;i<=N;i++)people[i]=new ArrayList<Integer>();
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				people[num1].add(num2);
				people[num2].add(num1);
			}
			
			boolean[] visited = new boolean[N+1];
			answer=0;
			for(int i=1;i<=N;i++) {
				bfs(i,visited);
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
    
    public static void bfs(int start, boolean[] visited) {
    	if(visited[start])return;
    	answer++;
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	visited[start]=true;
    	q.add(start);
    	
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		for(Integer next : people[now]) {
    			if(!visited[next]) {
    				visited[next]=true;
    				q.add(next);
    			}
    		}
    	}
    }
}
