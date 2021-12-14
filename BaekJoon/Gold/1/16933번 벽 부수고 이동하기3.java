//16933번 벽 부수고 이동하기3.java
package boj20211215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기3_16933 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class position{
    	int i;
    	int j;
    	int wall;
    	boolean day;
    	int cnt;
    	position(int i, int j, int wall, boolean day, int cnt) {
			this.i=i;
			this.j=j;
			this.wall=wall;
			this.day=day;
			this.cnt=cnt;
		}
    }
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		boolean[][][] visit = new boolean[N+1][M+1][K+1];
		
		for(int i=1;i<=N;i++) {
			String line = br.readLine();
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(line.substring(j-1,j));
			}
		}
		
		bfs(map, visit, new position(1, 1, 0, true,1),N,M,K);
		
	}
    
    static void bfs(int[][]map, boolean[][][] visit, position start, int N, int M, int K) {
    	int[] di = {1,-1,0,0};
    	int[] dj = {0,0,1,-1};
    	Queue<position> q = new LinkedList<position>();
    	q.add(start);
    	visit[start.i][start.j][start.wall]=true;
    	while(!q.isEmpty()) {
    		position now = q.poll();
    		if(now.i==N && now.j==M) {
    			System.out.println(now.cnt);
    			return;
    		}
    		for(int d=0;d<4;d++) {
    			int i = now.i+di[d];
    			int j = now.j+dj[d];
    			int w = now.wall;
    			boolean day = now.day;
    			
    			if(1<=i && i<=N && 1<=j && j<=M) {
    				if(map[i][j]==0 && !visit[i][j][w]) {
        				//벽이 아닌 경우
        				visit[i][j][w] = true;
        				q.add(new position(i, j, w,!day,now.cnt+1));
        			}
    				
        			if(map[i][j]==1 && w<K) {
        				//벽이지만 부술 수 있는 경우
        				//낮일 경우
        				if(day && !visit[i][j][w+1]) {
        					visit[i][j][w+1] = true;
            				q.add(new position(i, j, w+1,!day,now.cnt+1));
        				}
        				//밤일 경우
        				//낮이 되기를 기다렸다가 부심
        				else if(!day && !visit[i][j][w+1]){
            				q.add(new position(now.i, now.j, w,!day,now.cnt+1));
        				}
        			}
    			}
    		}
    	}
    	System.out.println(-1);
    }
}
