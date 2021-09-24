//7576번 토마토.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] tomato = new int[N][M];
		boolean check = false;
		int day=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(tomato,N,M);
		
		out : for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tomato[i][j]==0) {
					check=true;
					break out;
				}
				if(tomato[i][j]-1 > day) {
					day = tomato[i][j]-1;
				}
			}
		}
		
		if(check)System.out.println(-1);
		else System.out.println(day);
	}
	static void bfs(int[][] tomato, int N, int M) {
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		Queue<point> q = new LinkedList<point>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tomato[i][j]==1) {
					q.add(new point(i, j));
				}
			}
		}
		while(!q.isEmpty()) {
			point now = q.poll();
			for(int d=0;d<4;d++) {
				point next = new point(now.i+di[d],now.j+dj[d]);
				if(0<=next.i && next.i<N && 0<=next.j && next.j<M) {
					if(tomato[next.i][next.j]==0) {
						tomato[next.i][next.j] = tomato[now.i][now.j]+1;
						q.add(next);
					}
				}
			}
		}
	}
	
	static class point{
		int i;
		int j;
		point(int i, int j){
			this.i=i;
			this.j=j;
		}
	}
	
}
