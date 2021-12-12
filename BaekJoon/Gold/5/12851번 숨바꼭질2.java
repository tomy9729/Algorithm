//12851번 숨바꼭질2.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질2_12851 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] visit;
    static int count;
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		visit = new int[100001];
		Arrays.fill(visit, -1);
		count =0;
		bfs(visit, N, K);
		System.out.println(visit[K]);
		System.out.println(count);
	}
    
    static void bfs(int[] visit,int N, int K) {
    	Queue<Integer> q = new LinkedList<Integer>();
    	visit[N]=0;
    	q.add(N);
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		
    		if(now==K) {
    			count++;
    		}
    		
    		if(2*now<=100000 && (visit[2*now]==-1 || visit[2*now] >= visit[now]+1)) {
    			visit[2*now] = visit[now]+1;
    			q.add(2*now);
    		}
    		if(now+1<=100000 && (visit[now+1]==-1 || visit[now+1] >= visit[now]+1)) {
    			visit[now+1] = visit[now]+1;
    			q.add(now+1);
    		}
    		if(now-1>=0 && (visit[now-1]==-1 || visit[now-1] >= visit[now]+1)) {
    			visit[now-1] = visit[now]+1;
    			q.add(now-1);
    		}
    		
    	}
    }
    
}
