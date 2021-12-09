//13549번 숨바꼭질3.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] visit = new int[100001];
		Arrays.fill(visit, -1);
		
		System.out.println(bfs(visit, N, K));
	}
    
    static int bfs(int[] visit,int N, int K) {
    	Queue<Integer> q = new LinkedList<Integer>();
    	visit[N]=0;
    	q.add(N);
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		
    		if(now==K) {
    			return visit[now];
    		}
    		
    		if(2*now<=100000 && (visit[2*now]==-1 || visit[2*now] > visit[now])) {
    			visit[2*now] = visit[now];
    			q.add(2*now);
    		}
    		if(now+1<=100000 && (visit[now+1]==-1 || visit[now+1] > visit[now]+1)) {
    			visit[now+1] = visit[now]+1;
    			q.add(now+1);
    		}
    		if(now-1>=0 && (visit[now-1]==-1 || visit[now-1] > visit[now]+1)) {
    			visit[now-1] = visit[now]+1;
    			q.add(now-1);
    		}
    		
    	}
    	return 0;
    }
    
}
